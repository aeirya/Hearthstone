package com.bubble.hearthstone.module.logic.arena;

import java.util.List;

import com.bubble.hearthstone.model.card.Card;

public class HomePlayer extends Player {
    private final List<Card> cards;
    private int mana;

    public HomePlayer() {
        cards = null;
    }
}
