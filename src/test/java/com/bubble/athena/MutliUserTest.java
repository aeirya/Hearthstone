package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.GameClient;
import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;

import org.junit.Test;

public class MutliUserTest {
    private boolean success = false;
    
    @Test
    public static void main(String[] args) {
        MutliUserTest test = new MutliUserTest();
        assertTrue(test.success);
    }

    MutliUserTest() {
        runServer();
        ServerAPI api1 = api();
        api1.login("a", "a");
        ServerAPI api2 = api();
        api2.singup("b", "b");
        api2.login("b", "b");
        api1.findMatch();
        api2.findMatch();
        api1.log();
        api2.log();
        success = true;
    }

    GameServer runServer() {
        GameServer server = new GameServer(8000);
        server.run();
        return server;
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