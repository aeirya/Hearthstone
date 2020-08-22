package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.GameClient;
import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;

import org.junit.After;
import org.junit.Test;

public class MutliUserTest {

    GameServer server;

    @Test
    public void matchShouldStart() {
        runServer();
        ServerAPI api1 = api();
        api1.login("a", "a");
        ServerAPI api2 = api();
        api2.singup("b", "b");
        api2.login("b", "b");
        api1.findMatch();
        api2.findMatch();
        api2.log();
        assertTrue(api1.getResponse().isOK());
    }

    @After
    public void after() {
        server.stop();
    }

    GameServer runServer() {
        server = new GameServer(8000);
        server.run();
        sleep(50);
        return server;
    }

    @SuppressWarnings("all")
    void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            //
        }
    }

    GameClient runClient() {
        final GameClient client = new GameClient("localhost", 8000);
        client.run();
        return client;
    }

    ServerAPI api() {
        return runClient().get();
    }
}