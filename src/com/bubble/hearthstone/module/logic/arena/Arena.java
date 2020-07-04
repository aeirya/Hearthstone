package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventDispatcher;
import com.bubble.hearthstone.module.event.IEventHandler;

public class Arena implements IEventHandler, IEventDispatcher {

    private final Player player1;
    private final Player player2;
    private final CombatMaster combatMaster;
    private final Battleground battleground;
    private final ArenaEventHandler eventHandler;

    public Arena(Player player1, Player player2) {
        eventHandler = new ArenaEventHandler(this);
        combatMaster = new CombatMaster();
        battleground = new Battleground();
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startSession() {
        //
    }

    @Override
    public void handle(IEvent event) {
        eventHandler.handle(event);
    }

    public void handleBattleEvent(IBattleEvent event) {
        battleground.handle(event);
        combatMaster.handle(event);
    }

    @Override
    public void dispatch(IEvent event) {
        EventSystem.dispatch(event);
    }
}