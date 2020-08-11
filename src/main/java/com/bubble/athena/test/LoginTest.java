package com.bubble.athena.test;

import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;

import com.bubble.athena.client.GameClient;

public class LoginTest {
    public static void main(String[] args) {
        GameServer server = new GameServer(8000);
        server.run();
    
        final GameClient client = new GameClient("localhost", 8000);
        client.run();
        ServerAPI api = client.get();
        api.singup("a", "a");
        api.login("a", "a");
    }
}