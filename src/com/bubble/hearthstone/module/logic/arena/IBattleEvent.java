package com.bubble.hearthstone.module.logic.arena;

public interface IBattleEvent extends IArenaEvent {
    default void process(ArenaEventHandler arena) {
        arena.handleBattleEvent(this);
    }
    
    void process(CombatMaster master);
}