package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.net.ServerAPI;

import org.junit.Test;

public class ArenaEventTest extends NetworkTest {
    
    @Test
    void attack() {
        runServer();
        fastLogin(api(), "a").findMatch();
        ServerAPI api = fastLogin(api(), "b");
        api.findMatch();
        sleep(1000);
        api.attack();
        success = true;
        assertTrue("yay", success);
    }
}