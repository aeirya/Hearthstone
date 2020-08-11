package com.bubble.athena;

import static org.junit.Assert.assertNotNull;

import com.bubble.athena.server.score.Scoreboard;

import org.junit.Test;

public class ScoreboardTest {

    @Test
    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();
        assertNotNull(scoreboard.getUserEntry("name"));
    }
}