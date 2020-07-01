package com.bubble.hearthstone.model.hero;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.card.Card;

// will be used in the shop or deck manager i guess
public class HeroRecord {
    private final Hero hero;
    private final List<Card> specialCards;
    private boolean isUnlocked;

    public HeroRecord(Hero hero) {
        this.hero = hero;
        this.specialCards = new ArrayList<>();
        this.isUnlocked = true;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void unlock() {
        isUnlocked = true;
    }

    public boolean isOwns(Card card) {
        return specialCards.contains(card);
    }

    public String getName() {
        return hero.getName();
    }
}