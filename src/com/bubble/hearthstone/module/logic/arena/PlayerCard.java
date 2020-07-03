package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.model.card.Card;

public class PlayerCard extends Card {

    private final Player player;

    public PlayerCard(Card card, Player player) {
        super(
            card.name, 
            card.manaCost, 
            card.type, 
            card.heroClass, 
            card.rarity, 
            card.abilities, 
            card.description
        );
        this.player = player;
    }

    public void act() {
        abilities.forEach(
            ability -> {
                ability.act();
            }
        );
    }
}