package com.bubble.athena.server.arena;

public class Game {
    private final Player home;
    private final Player away;
    private final IArena arena;

    public Game(Player home, Player away) {
        this.home = home;
        this.away = away;
        arena = new Arena(this);
    }

    public Player getWinner() {
        if (isWon(home)) return home;
        else if (isWon(away)) return away;
        return null;
    }

    public Player getPlayer(String name) {
        if(home.getName().equals(name)) return home;
        else if(away.getName().equals(name)) return away;
        else return null;
    }

    public boolean isWon(String player) {
        return isWon(getPlayer(player));
    }

    private boolean isWon(Player player) {
        return getOpponent(player).isDead();
    }

    private Player getOpponent(Player player) {
        if (player.equals(away)) return home;
        else return away;
    }

    public boolean isFinished() {
        return getWinner() == null;
    }

    public IArena getArena() {
        return arena;
    }
}