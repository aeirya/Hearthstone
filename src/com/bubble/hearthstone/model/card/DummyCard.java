package com.bubble.hearthstone.model.card;

import java.util.List;

import com.bubble.hearthstone.model.card.ability.Ability;
import com.bubble.hearthstone.model.card.ability.AbilityType;
import com.bubble.hearthstone.model.hero.HeroClass;

public class DummyCard extends Card {

    public DummyCard() {
        super(
            "Zeus", 2,
            CardType.MINION, 
            HeroClass.WARLOCK, 
            CardRarity.EPIC, 
            List.of(new Ability(AbilityType.DRAW, "arg1", "arg2"), new Ability(AbilityType.HASTE, "args")),
            "no description");
    }
    
}