package com.bubble.hearthstone;

import com.bubble.hearthstone.client.GameClient;
import com.bubble.hearthstone.server.GameServer;

public class Hearthstone {
    public static void main(String[] args) {
        new GameServer().run();
        new GameClient().run();
    }
}