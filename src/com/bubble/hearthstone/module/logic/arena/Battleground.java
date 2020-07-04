package com.bubble.hearthstone.module.logic.arena;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.model.card.monster.Monster;
import com.bubble.hearthstone.module.event.IEventHandler;

public class Battleground implements IEventHandler<IBattleEvent> {
    
    private final List<Monster> friends;
    private final List<Monster> enemies;

    public Battleground() {
        friends = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    @Override
    public void handle(IBattleEvent event) {
        // friends.parallelStream().
        // reflect upon all monsters
    }

}