package com.bubble.hearthstone.card;

import com.bubble.hearthstone.util.serialize.Serializable;
import com.google.gson.InstanceCreator;

public abstract class Ability implements Serializable, InstanceCreator<Ability> {
    
    public AbilityType type;
    public AbilityArgument arguments;

    public abstract void act();

    public enum AbilityType {
        DRAW, HASTE, POKE
    }

    public static class AbilityArgument {

        private final String[] args;
        // private int num

        public AbilityArgument(String... args) {
            this.args = args;
        }
    }
}