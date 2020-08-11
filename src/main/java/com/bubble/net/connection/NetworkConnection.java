package com.bubble.net.connection;

import java.net.Socket;

public class NetworkConnection implements IDataReceiver {
    private final DataConnection connection;
    private final INetworkReceiver receiver;

    public NetworkConnection(INetworkReceiver receiver, Socket socket) {
        this.receiver = receiver;
        connection = new DataConnection(this, socket);
    }

    public void start() {
        connection.start();
    }

    public void send(String data) {
        send(data.getBytes());
    }
    
    private void send(byte[] data) {
        connection.send(data);
    }

    public void receive(byte[] data) {
        receive(new String(data));
    }

    private void receive(String data) {
        receiver.receive(data);
    }

    public void terminate() {
        receiver.terminate();
    }
}