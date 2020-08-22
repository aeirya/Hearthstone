package com.bubble.athena.game.deck;

import java.util.ArrayList;
import java.util.List;

import com.bubble.athena.game.card.Card;
import com.bubble.athena.game.hero.IHero;

public class Deck {
    private final List<Card> cards;

    private String name;
    private IHero hero;

    public Deck() {
        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IHero getHero() {
        return hero;
    }

    public void setHero(IHero hero) {
        this.hero = hero;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }
}