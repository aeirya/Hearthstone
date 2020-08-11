package com.bubble.net.client.service;

public class NetworkService implements INetworkService {

    private Server server;
    private final LockedQueue responses;
    private final ServerConnector connector;

    public NetworkService(String ip, int port) {
        connector = new ServerConnector(ip, port);
        responses = new LockedQueue();
    }

    public void connect() {
        server = new Server(this, connector.connect());
    }

    public void send(String data) {
        server.send(data);
    }

    public void bye() {
        System.out.println("ok... disconnected");
    }

    public void handle(String data) {
        responses.push(data);
    }

    public String getNext() {
        return responses.getNext();
    }
}