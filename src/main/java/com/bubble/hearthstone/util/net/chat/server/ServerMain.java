package com.bubble.hearthstone.util.net.chat.server;

import java.io.IOException;

import com.bubble.hearthstone.util.net.chat.client.ChatClient;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        final int serverPort = 9999;
        new ChatServer(serverPort).start();
    }
}