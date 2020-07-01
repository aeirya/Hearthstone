package com.bubble.hearthstone.util.net.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ChatServer extends Thread {

    private final ServerSocket serverSocket;
    private final List<ClientHandler> clients;
    
    ChatServer(int serverPort) throws IOException {
        serverSocket = new ServerSocket(serverPort);
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                final Socket request = serverSocket.accept();
                final ClientHandler client = addClient(request);
                client.start();
                
            } catch (IOException e) {
                //
            }
        }
    }

    private ClientHandler addClient(Socket socket) {
        final ClientHandler client = new ClientHandler(this, socket);
        clients.add(
            client
        );
        return client;
    }

    public void sendToAll(ClientHandler sender, String message) {
        final String logMsg = "sending message to all clients";
        Logger.getLogger(this.getClass().getName()).info(logMsg);
        clients.forEach(
            client -> {
                if (!client.equals(sender) && client.isAlive()) {
                    client.send(message);
                    System.out.println("sent");
                }
            } 
            );
    }
}