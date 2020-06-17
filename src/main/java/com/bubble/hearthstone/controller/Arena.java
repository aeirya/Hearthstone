package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.model.Player;
import com.bubble.hearthstone.model.arena.Battleground;
import com.bubble.hearthstone.model.arena.CombatMaster;
import com.bubble.hearthstone.net.event.events.arena.ArenaEvent;
import com.bubble.hearthstone.net.event.events.arena.battleground.BattlegroundEvent;
import com.bubble.hearthstone.util.time.ArenaTimer;

public class Arena {
    
    private final Player player;
    private final ArenaTimer timer;
    private final Battleground battleground;
    private final CombatMaster combatMaster;

    public Arena(Player player) {
        this.timer = new ArenaTimer();
        this.combatMaster = new CombatMaster();
        this.player = player;
        this.battleground = new Battleground(player);
    }

    void start() {
        timer.start();
    }

    public void handleEvent(ArenaEvent event) {
        event.process(this);
    }

    public void handleBattlegroundEvent(BattlegroundEvent event) {
        combatMaster.handleEvent(event);
    }
    
    public Player getPlayer(String name) {
        // change this later, maybe use array list for players
        if (player.getName().equals(name)) return player;
        else {
            return null;
        }
    }

    Player getPlayer() {
        return player;
    }

    Battleground getBattleground() {
        return battleground;
    }
}