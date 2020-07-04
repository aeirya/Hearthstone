package com.bubble.hearthstone.model.card.deck;

import java.util.List;

import com.bubble.hearthstone.model.card.Card;

public class Deck {
    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }
    
}