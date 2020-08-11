package com.bubble.athena.server.arena;

public class Player {
    private final String name;
    private final IDeck deck;
    private final IHero hero;

    public Player(String name, IDeck deck, IHero hero) {
        this.name = name;
        this.deck = deck;
        this.hero = hero;
    }

    public boolean isDead() {
        return hero.getHealth() <= 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Player)) return false;
        return ((Player) other).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + hero.hashCode() + deck.hashCode();
    }
}
