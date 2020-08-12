package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.GameClient;
import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;

import org.junit.Test;

public class NetworkTest {
    protected boolean success = false;

    @Test
    public static void main(String[] args) {
        assertTrue(new NetworkTest().success);
    }

    GameServer runServer() {
        GameServer server = new GameServer(8000);
        server.run();
        // sleep(500);
        return server;
    }

    void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
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

    ServerAPI fastLogin(ServerAPI api, String str) {
        api.login(str, str);
        return api;
    }
}