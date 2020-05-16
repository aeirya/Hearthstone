package com.bubble.hearthstone.card.deck;

import com.bubble.hearthstone.card.Ability.AbilityArgument;
import com.bubble.hearthstone.card.Ability.AbilityType;
import com.bubble.hearthstone.card.Card.CardRarity;
import com.bubble.hearthstone.card.Card.CardType;
import com.bubble.hearthstone.card.abilities.AbilityDamage;
import com.bubble.hearthstone.card.registry.CardFactory;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Deck {
    private final String name; //will be implement a naming system later
    private final Collection<CardRecord> cards;
    
    public Deck(String name, Collection<CardRecord> cards) {
        this.cards = cards;
        this.name = name;
    }

    public Deck(String name) {
        cards = new ArrayList<>();
        DEFAULT.cards.forEach(card -> cards.add(card.copy()));
        this.name = name;
    }

    public List<String> listCardNames() {
        final List<String> names = new ArrayList<>();
        cards.forEach(card -> names.add(card.getName()));
        return names;
    }

    public void addCard(CardRecord card) {
        cards.add(card);
    }

    public void removeCard(CardRecord card) {
        cards.remove(card);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        listCardNames().forEach(cardname -> builder.append("\n" + cardname));
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String toTable() {
        return Deck.makeTable(this);
    }

    public static String makeTable(Deck deck) {
        final StringBuilder builder = new StringBuilder();
        builder.append(
            "card\t\t\tmana\ttype\tclass\trarity\t\tdescription\n"
        ); 
        builder.append("--------------------------------------------------\n");
        deck.cards.forEach(card -> builder.append(card.makeRecord() + "\n"));
        return builder.toString();
    }

    private static final CardRecord sampleCard = new CardFactory().build("hi", 1, CardType.MINION , HeroClass.MAGE, CardRarity.LEGENDARY, List.of(new AbilityDamage(AbilityType.DRAW, new AbilityArgument())), "HIHSDHDHS") ;
    private static final CardRecord sampleCard2 = sampleCard.copy().setDescription("this is another card").setHeroClass(HeroClass.ROUGE).setName("Black mage"); 
    public static final Deck DEFAULT = new Deck("starter", Arrays.asList(sampleCard, sampleCard2));
}