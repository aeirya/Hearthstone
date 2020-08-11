package com.bubble.athena.server.arena;

import com.bubble.athena.server.ServiceLocator;
import com.bubble.athena.server.user.OnlineUser;

public class GameBuilder {
    public Game newGame(OnlineUser u1, OnlineUser u2) {
        return new Game(
            createPlayer(u1),
            createPlayer(u2)
        );
    }

    private UserSave getSave(String user) {
        return ServiceLocator.getResources().getSave(user);
    }

    private UserSave getSave(OnlineUser user) {
        return getSave(user.getUsername());
    }

    private Player createPlayer(OnlineUser user) {
        final IDeck deck = getSave(user).getCurrentDeck();
        final IHero hero = getSave(user).getCurrentHero();
        final String name = user.getUsername();
        return new Player(
            name, deck, hero
        );
    } 
}