package com.bubble.hearthstone.net.event.events.arena.battleground;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.model.arena.CombatMaster;
import com.bubble.hearthstone.net.event.events.arena.ArenaEvent;

public abstract class BattlegroundEvent extends ArenaEvent {

    @Override
    public void process(Arena arena) {
        arena.handleBattlegroundEvent(this);
    }
    
    public abstract void process(CombatMaster combatMaster);
}