package com.bubble.athena;

import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import com.bubble.athena.client.GameClient;

public class LoginTest {
    @Test
    public void clientShouldLogin() {
        GameServer server = new GameServer(8000);
        server.run();
        sleep();
        final GameClient client = new GameClient("localhost", 8000);
        client.run();
        ServerAPI api = client.get();
        api.singup("a", "a");
        api.login("a", "a");
        assertNotNull(api.getUsername());
    }

    @SuppressWarnings("all")
    private void sleep() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
        }
    }
}