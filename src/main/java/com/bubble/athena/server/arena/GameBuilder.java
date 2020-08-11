package com.bubble.athena.server.arena;

import com.bubble.athena.server.user.OnlineUser;

public class GameBuilder {
    public Game newGame(OnlineUser u1, OnlineUser u2) {
        // Player p1 = toPlayer(u1);
        // Player p2 = toPlayer(u2);
        // Game game = new Game(p1, p2);
        // u1.startMatch(game, p1);
        // u2.startMatch(game, p2);
        // game.setHomePlayer(Sign.X);
        return new Game();
    }
}