package com.bubble.hearthstone.card;

import java.lang.reflect.Type;

public class AbilityImpl extends Ability {

    public AbilityImpl(AbilityType type, AbilityArgument arguemnts) {
        this.type = type;
        this.arguments = arguemnts;
    }

    public void act() {
        //do nothing, it's dummy
    }

    @Override
    public Ability createInstance(Type typePassedByGson) {
        return new AbilityImpl(type, arguments);
    }
}