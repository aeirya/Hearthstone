package com.bubble.hearthstone.util.net.chat.client;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        final String serverIP = "localhost";
        final int serverPort = 9999;

        new ChatClient(serverIP, serverPort).start();
    }
}