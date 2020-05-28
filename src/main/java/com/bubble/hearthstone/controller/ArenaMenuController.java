package com.bubble.hearthstone.controller;

import java.util.List;

import com.bubble.hearthstone.card.monster.Monster;
import com.bubble.hearthstone.model.arena.Battleground;
import com.bubble.hearthstone.model.arena.Board;
import com.bubble.hearthstone.model.arena.Hand;

public class ArenaMenuController {
    
    private final Arena arena;

    public ArenaMenuController(Arena arena) {
        this.arena = arena;
    }

    public Hand getPlayerHand() {
        return arena.getPlayer().getHand();
    }
    
    public List<Monster> getPlayerMonsters() {
        return arena.getPlayer().getMonsters();
    }

    public Battleground getBattleground() {
        return arena.getBattleground();
    }
    
    public Board getBoard() {
        return getBattleground().getBoard();
    }
}