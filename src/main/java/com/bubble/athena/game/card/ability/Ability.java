package com.bubble.athena.game.card.ability;

public abstract class Ability {
    private final AbilityType type;

    public Ability(AbilityType type) {
        this.type = type;
    }

    public abstract void act();
}