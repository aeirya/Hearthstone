package com.bubble.hearthstone.model.card.ability.abilities;

import com.bubble.hearthstone.model.card.ability.Ability;
import com.bubble.hearthstone.model.card.ability.AbilityType;

public class AbilityDraw extends Ability {

    private final int n;

    public AbilityDraw(int n) {
        super(AbilityType.DRAW);
        this.n = n;
    }

    public AbilityDraw(String args) {
        super(AbilityType.DRAW);
        n = Integer.parseInt(args);
    }

    public void act() {
        //
    }
}