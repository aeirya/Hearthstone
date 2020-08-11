package com.bubble.athena.server.arena;

public class Game {
    private final Player home;
    private final Player away;

    public Game(Player home, Player away) {
        this.home = home;
        this.away = away;
    }

    public Player getWinner() {
        if (isWon(home)) return home;
        else if (isWon(away)) return away;
        return null;
    }

    public boolean isWon(Player player) {
        return getOpponent(player).isDead();
    }

    public Player getOpponent(Player player) {
        if (player.equals(away)) return home;
        else return away;
    }

    public boolean isFinished() {
        return getWinner() == null;
    }
}