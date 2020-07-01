package com.bubble.hearthstone.util.net.chat.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
    private final Socket socket;
    private final ChatServer chatServer;
    private final String clientName;

    ClientHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
        this.clientName = socket.getRemoteSocketAddress().toString();
    }

    @Override
    public void run() {
        try (final Scanner scanner = new Scanner(socket.getInputStream())) {
            System.out.println("client got the input stream");
            while (true) {
                final String message = clientName + " : " + scanner.nextLine();
                chatServer.sendToAll(this, message);
            }
        } catch (IOException e) {
            //
        }
    }

    public void send(String message) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(socket.getOutputStream());
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}