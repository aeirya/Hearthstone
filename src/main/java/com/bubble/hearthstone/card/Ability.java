package com.bubble.hearthstone.card;

import com.bubble.hearthstone.util.serialize.Serializable;
import com.google.gson.InstanceCreator;

public abstract class Ability implements Serializable, InstanceCreator<Ability> {
    
    public AbilityType type;
    public AbilityArgument arguments;

    public abstract void act();

    public enum AbilityType {
        DRAW
    }

    public static class AbilityArgument {
        int num;
    }
}