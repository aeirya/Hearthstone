package com.bubble.hearthstone.model;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.card.monster.Monster;
import com.bubble.hearthstone.model.arena.Hand;
import com.bubble.hearthstone.net.user.UserSave;

public class Player {
    
    private final Hand hand;

    public Player(UserSave save) {
        this.hand = new Hand(
            save.getCurrentDeck()
        );
    }
    
    public Hand getHand() {
        return hand;
    }

    public List<Monster> getMonsters() {
        // implement this
        return new ArrayList<>();
    }
}