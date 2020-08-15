package com.bubble.athena;

import static org.junit.Assert.assertNotNull;

import com.bubble.athena.client.GameClient;
import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;

import org.junit.Test;

public class UserTest {

    @Test
    void test() {
        int port = 8000;
        String ip = "localhost";
        GameServer server = new GameServer(port);
        server.run();
        GameClient client = new GameClient(ip, port);
        client.run();
        ServerAPI api = client.get();
        api.singup("a", "a");
        api.login("a", "a");
        api.logout();
        api.removeUser("a", "a");
        api.singup("b", "b");
        api.login("b", "b");
        assertNotNull(api.getUsername());
    }

    public static void main(String[] args) {
        new UserTest().test();
    }
}