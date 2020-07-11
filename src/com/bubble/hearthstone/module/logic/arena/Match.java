package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.net.user.User;

public class Match {

    private final Player player1;
    private final Player player2;

    public Match(User user1, User user2) {
        player1 = new HomePlayer();
        player2 = new AwayPlayer();
    }

    public Arena createArena() {
        return new Arena(player1, player2);
    }

    private Player getPlayer(User user) {
        if(player1.getName().equals(user.getUsername())) {
            return player1;
        }
        else {
            return player2;
        }
    }

    private Player loadPlayer(User user) {
        /**
         * load save
         * make player
         * return it
         */
        return null;
    }
}