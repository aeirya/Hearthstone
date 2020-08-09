package com.bubble.hearthstone.net2.event.events.arena.battleground;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.model.arena.CombatMaster;
import com.bubble.hearthstone.net2.event.events.arena.IArenaEvent;

public interface BattlegroundEvent extends IArenaEvent {

    @Override
    default void process(Arena arena) {
        arena.handleBattlegroundEvent(this);
    }
    
    void process(CombatMaster combatMaster);
}