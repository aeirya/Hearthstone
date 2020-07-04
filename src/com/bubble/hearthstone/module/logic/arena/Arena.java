package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventDispatcher;
import com.bubble.hearthstone.module.event.IEventHandler;

public class Arena implements IEventHandler, IEventDispatcher {

    private final Player home;
    private final Player away;
    private final CombatMaster combatMaster;
    private final Battleground battleground;
    private final ArenaEventHandler eventHandler;

    private boolean isHomeTurn;
    private int timer;
    private final int TPS = 60; // used with timer

    public Arena(Player home, Player away) {
        eventHandler = new ArenaEventHandler(this);
        combatMaster = new CombatMaster();
        battleground = new Battleground();
        this.home = home;
        this.away = away;
    }

    public void startSession() {
        //
    }

    public void updateArena() {
        timer -= 1;
        if (timer == 0) {
            // end turn
            // reset timer
        }
    }

    private void endTurn() {
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