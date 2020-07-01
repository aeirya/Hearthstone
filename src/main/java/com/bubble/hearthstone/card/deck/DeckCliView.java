package com.bubble.hearthstone.card.deck;

import java.util.ArrayList;
import java.util.List;

//functions moved from deck to here
//connect these two classes later on
public class DeckCliView {
    
    private final Deck deck;

    public DeckCliView(Deck deck) {
        this.deck = deck;
    }

    public List<String> listCardNames() {
        final List<String> names = new ArrayList<>();
        deck.getCards().forEach(card -> names.add(card.getName()));
        return names;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        listCardNames().forEach(cardname -> builder.append("\n" + cardname));
        return builder.toString();
    }

    public String toTable() {
        return DeckCliView.makeTable(deck);
    }

    public static String makeTable(Deck deck) {
        final StringBuilder builder = new StringBuilder();
        builder.append("card\t\t\tmana\ttype\tclass\trarity\t\tdescription\n");
        builder.append("-------------------------------------------------------\n");
        deck.getCards().forEach(card -> builder.append(card.makeRecord() + "\n"));
        return builder.toString();
    }
}