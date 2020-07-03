package com.bubble.hearthstone.model.card.ability;

import com.bubble.hearthstone.util.serialize.Serializable;

public abstract class Ability implements Serializable {
    private final AbilityType type;

    public Ability(AbilityType type) {
        this.type = type;
    }

    public abstract void act();
}