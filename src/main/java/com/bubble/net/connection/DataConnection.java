package com.bubble.net.connection;

import java.net.Socket;

public class DataConnection implements IDataReceiver {

    private final IDataReceiver receiver;
    private final IConnectionListener listener;
    private final IConnectionDispatcher dispatcher;

    public DataConnection(IDataReceiver receiver, Socket socket) {
        this.receiver = receiver;
        listener = new DataListener(this, socket);
        dispatcher = new DataDispacher(socket);
    }

    public void start() {
        listen();
    }

    private void listen() {
        listener.listen();
    }

    public void receive(byte[] data) {
        receiver.receive(data);
    }

    public void send(byte[] data) {
        dispatcher.send(data);
    }

    public void terminate() {
        receiver.terminate();
    }
}