package com.bubble.hearthstone.module.logic.arena;

import java.util.List;

import com.bubble.hearthstone.model.card.Card;
import com.bubble.hearthstone.model.card.deck.Deck;
import com.bubble.hearthstone.model.hero.Hero;

public abstract class Player {
    
    protected final Deck deck;
    protected final Hero hero;
    protected int selectedCardNumber;
    protected final String name = "";
    // private final String currentQuest = "";
    
    public Player() {
        deck = null;
        hero = null;
    }

    public Hero getHero() {
        return hero;
    }

    public int getMana() {
        return 0;
    }

    public List<Card> getCards() {
        return null;
    }

    public String getName() {
        return name;
    }
}