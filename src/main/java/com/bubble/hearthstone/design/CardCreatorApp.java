package com.bubble.hearthstone.design;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bubble.hearthstone.card.Ability;
import com.bubble.hearthstone.card.AbilityImpl;
import com.bubble.hearthstone.card.Ability.AbilityArgument;
import com.bubble.hearthstone.card.Ability.AbilityType;
import com.bubble.hearthstone.card.Card.CardRarity;
import com.bubble.hearthstone.card.Card.CardType;
import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.card.deck.DeckCliView;
import com.bubble.hearthstone.card.registry.CardFactory;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import com.bubble.hearthstone.util.log.MyFileWriter;
import com.bubble.hearthstone.util.resource.CardLoader;
import com.bubble.hearthstone.util.serialize.CardSerializer;

public class CardCreatorApp implements Runnable {

    private final Scanner in;
    private final PrintStream out;

    public static void main(String[] args) {
        new CardCreatorApp().run();
    }

    private CardCreatorApp() {
        this.in = new Scanner(System.in);
        this.out = System.out;
        //todo: make cli table class
    }

    @Override
    public void run() {
        final Deck deck = new DeckLoader().load();
        printf(deck);
        while (true) {
            final CardRecord card = new InputParser().getCard();
            deck.addCard(card);
            new CardSaver().save(card);
            printf(deck);
            if (isFinished())
                break;
        }
    }

    /**
     * @deprecated
     */
    @Deprecated
    private void print(Deck deck) {
        out.println(DeckCliView.makeTable(deck));
    }

    private void printf(Deck deck) {
        new Table(deck).printf();
    }

    private boolean isFinished() {
        out.print("Do you want to continue? (y/n)");
        final String response = in.nextLine();
        return response.equalsIgnoreCase("n");
    }

    private class InputParser {

        private final List<String> properties = List.of("card name", "mana cost", "card type", "hero class",
                "card rarity", "card ability", "description");

        private String current;

        CardRecord getCard() {
            final Iterator<String> it = properties.iterator();
            final String name = next(it);
            final int manaCost = getNumber(it);
            final CardType type = getCardType(it);
            final HeroClass heroClass = getHeroClass(it);
            final CardRarity rarity = getCardRarity(it);
            final List<Ability> abilities = getAbilities(it);
            final String description = next(it);
            final CardFactory factory = new CardFactory();
            return factory.build(name, manaCost, type, heroClass, rarity, abilities, description);
        }

        private CardType getCardType(Iterator<String> it) {
            return getEnum(CardType.class, it);
        }

        private HeroClass getHeroClass(Iterator<String> it) {
            return getEnum(HeroClass.class, it);
        }

        private CardRarity getCardRarity(Iterator<String> it) {
            return getEnum(CardRarity.class, it);
        }

        private List<Ability> getAbilities(Iterator<String> it) {
            final String input = next(it);
            if (input.isBlank())
                return new ArrayList<>();
            final LinkedList<String> next = new LinkedList<>(Arrays.asList(input.split(" ")));
            final String type = next.removeFirst();
            final AbilityType abilityType = getEnum(AbilityType.class, type);
            final String[] arguments = next.toArray(new String[0]);
            final AbilityArgument abilityArgs =  new AbilityArgument(arguments);
            return List.of(new AbilityImpl(abilityType, abilityArgs));
        }

        private int getNumber(Iterator<String> it) {
            final String text = next(it);
            Integer x = getNumber(text);
            while (x == null)
                x = getNumber(get(current));
            return x;
        }

        private Integer getNumber(String text) {
            try {
                return Integer.parseInt(text);
            } catch (Exception e) {
                return null;
            }
        }

        private <E extends Enum<E>> E getEnum(Class<E> clazz, Iterator<String> it) {
            final String text = next(it).toUpperCase();
            E e = getEnum(clazz, text);
            while (e == null) {
                e = getEnum(clazz, get(current).toUpperCase());
            }
            return e;
        }

        private <E extends Enum<E>> E getEnum(Class<E> clazz, String text) {
            try {
                return Enum.valueOf(clazz, text);
            } catch (Exception e) {
                return null;
            }
        }

        private String next(Iterator<String> it) {
            current = it.next();
            return get(current);
        }

        private String get(String property) {
            out.print("Enter " + property + ": ");
            return in.nextLine();
        }
    }

    private class CardSaver {
        static final String DIR = "data/config/cards/";

        private String serialize(CardRecord cardRecord) {
            final CardSerializer ser = new CardSerializer();
            return ser.serialize(cardRecord, CardRecord.class);
        }

        public void save(CardRecord card) {
            final String text = serialize(card);
            final MyFileWriter writer = new MyFileWriter(getSavePath(card), false);
            writer.write(text);
        }

        private String getSavePath(CardRecord card) {
            final String saveFormat = ".json";
            createIfNonExistant(DIR);
            return DIR + retrieveName(card) + saveFormat;
        }

        private void createIfNonExistant(String dir) {
            try {
                Files.createDirectories(Paths.get(dir));
            } catch (IOException e) {
                out.println(e.toString());
            }
        }

        private String retrieveName(CardRecord card) {
            final String name = card.getName();
            return name.replace(" ", "_").toLowerCase();
        }
    }

    private class DeckLoader {
        
        Deck load() {
            return new Deck("Your cards", loadCards());
        }

        private Collection<CardRecord> loadCards() {
            return new CardLoader().loadDir(CardSaver.DIR).values().stream().collect(Collectors.toList());
        }
    }

    private class Table {
        private final Deck deck;

        Table(Deck deck) {
            this.deck = deck;
        }

        private Collection<CardRecord> getCards() {
            return deck.getCards();
        }

        public void printf() {
            printLine();
            printTitle();
            printLine();
            for (CardRecord card : getCards()) {
                getOut().printf(
                    getFormat(), 
                    (Object[])card.getRecord()
                    );
                getOut().println();
            }
            printLine();
        }

        private String[] makeTitle() {
            return CardRecord.getRecordTitle();
        }

        /**
         * @deprecated
         */
        @Deprecated
        private String getTitleFormat() {
            final String block = "|%s";
            final StringBuilder builder = new StringBuilder();
            for (int i = 0; i < makeTitle().length; i++) {
                builder.append(block);
            }
            builder.append("|%n");
            return builder.toString();
        }

        private void printTitle() {
            getOut().printf(
                // getTitleFormat(),
                getFormat(),
                (Object[])makeTitle()
            );
            getOut().println();
        }

        private String getFormat() {
            final String nameFormat = "| %1$-20s ";
            final String manaFormat = "| %2$-5s ";
            final String typeFormat = "| %3$-10s ";
            final String classFormat = "| %4$-10s ";
            final String rarityFormat = "| %5$-10s ";
            final String descriptionFormat = "| %6$-30s ";
            return 
                nameFormat.concat(manaFormat)
                        .concat(typeFormat)
                        .concat(classFormat)
                        .concat(rarityFormat)
                        .concat(descriptionFormat);
        }

        private String getLine() {
            return new String(new char[96]).replace('\0', '-');
        }

        private void printLine() {
            getOut().println(getLine());
        }

        private PrintStream getOut() {
            return out;
        }
    }
}