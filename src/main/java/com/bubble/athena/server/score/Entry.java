package com.bubble.athena.server.score;

public class Entry {
    private final String user;
    private int wins;
    private int lost;

    Entry (String user) {
        this.user = user;
        wins = 0;
        lost = 0;
    }

    public int getScore() {
        return wins - lost;
    }

    public void win() {
        wins += 1;
    }

    public void lose() {
        lost += 1;
    }

    public void add(MatchResult result) {
        result.apply(this);
    }

    public int getWins() {
        return wins;
    }

    public int getLosts() {
        return lost;
    }

    public String getUser() {
        return user;
    }
}