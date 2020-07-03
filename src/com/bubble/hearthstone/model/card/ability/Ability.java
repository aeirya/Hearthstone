package com.bubble.hearthstone.model.card.ability;

import com.bubble.hearthstone.util.serialize.Serializable;

public class Ability implements Serializable {
    private final AbilityType type;
    private final String[] args;

    public Ability(AbilityType type, String... args) {
        this.type = type;
        this.args = args;
    }
}