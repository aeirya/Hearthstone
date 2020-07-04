package com.bubble.hearthstone.module.logic.arena.view;

public interface ArenaDrawable {
    public BattlegroundDrawable getBattleground();
    public PlayerDrawable getPlayer();
    // public Enemy getEnemy();
    public int getTimeRemaining();
}