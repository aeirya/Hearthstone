package com.bubble.hearthstone.util.net.chat.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ChatClient extends Thread {

    private final Socket socket;
    private final ChatTransmitter receiver;
    private final ChatTransmitter sender;

    public ChatClient(String serverIP, int port) throws IOException {
        this.socket = new Socket(serverIP, port);
        this.receiver = new ChatTransmitter(
            socket.getInputStream(), 
            System.out);
        this.sender = new ChatTransmitter(
            System.in, 
            new PrintStream(socket.getOutputStream()));
    }

    @Override
    public void run() {
        receiver.start();
        sender.start();
        while (isStillAlive()) {
            
        }
        receiver.interrupt();
    }

    private boolean isStillAlive() {
        return socket.isConnected() && sender.isAlive();
    }
}