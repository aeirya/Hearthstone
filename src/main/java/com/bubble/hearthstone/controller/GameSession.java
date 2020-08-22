package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.model.Player;
import com.bubble.hearthstone.net2.event.events.arena.ArenaEvent;
import com.bubble.hearthstone.net2.user.User;
import com.bubble.hearthstone.net2.user.UserSave;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class GameSession {
    
    private final Arena arena;

    public GameSession(User user, GameMode mode) {
        this.arena = new Arena(loadPlayer(user));
        if (mode == GameMode.OFFLINE) {
            // do sth about the player 2
        }
        start();
    }

    private void start() {
        arena.start();
    }

    private Player loadPlayer(User user) {
        final UserSave save = ServiceLocator.getResources().loadSave(user);
        return new Player(save);
    }

    public Arena getArena() {
        return arena;
    }

    public void handleArenaEvent(ArenaEvent event) {
        arena.handleEvent(event);
    }

    public enum GameMode {
        ONLINE, OFFLINE, AI
    }
}