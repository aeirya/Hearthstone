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
import java.util.List;

public class Deck {
    private final CardRecord sampleCard = new CardFactory().build("hi", 1, CardType.MINION , HeroClass.MAGE, CardRarity.LEGENDARY, List.of(new AbilityDamage(AbilityType.DRAW, new AbilityArgument())), "HIHSDHDHS") ;
    private List<CardRecord> cards = List.of(sampleCard);
    

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
    
    public static String makeTable(Deck deck) {
        final StringBuilder builder = new StringBuilder();
        builder.append(
            "card\tmana\ttype\tclass\trarity\t\tdescription\n"
        ); 
        builder.append("--------------------------------------------------\n");
        deck.cards.forEach(card -> builder.append(card.makeRecord() + "\n"));
        return builder.toString();
    }
}