package com.bubble.hearthstone.util.serialize;

import com.bubble.hearthstone.card.Ability;
import com.bubble.hearthstone.card.AbilityImpl;
import com.bubble.hearthstone.card.Ability.AbilityArgument;
import com.bubble.hearthstone.card.Ability.AbilityType;

public class CardSerializer extends GsonSerializer {
    
    public CardSerializer() {
        super(
            Ability.class, new AbilityImpl(AbilityType.DRAW, new AbilityArgument())
        );
    }
}