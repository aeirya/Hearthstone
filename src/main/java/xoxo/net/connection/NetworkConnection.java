package xoxo.net.connection;

import java.net.Socket;

public class NetworkConnection implements IDataReceiver {

    private final IDataReceiver handler;
    private final IConnectionListener listener;
    private final IConnectionDispatcher dispatcher;
    private boolean isAlive;

    public NetworkConnection(IDataReceiver receiver, Socket socket) {
        this.handler = receiver;
        listener = new DataConnectionListener(this, socket);
        dispatcher = new DataConnectionDispacher(socket);
    }

    public void start() {
        isAlive = true;
        connect();
        listen();
    }

    private void connect() {
        dispatcher.connect();
    }

    private void listen() {
        listener.listen();
    }

    public void receive(byte[] data) {
        handler.receive(data);
    }

    public void send(byte[] data) {
        dispatcher.send(data);
    }

    public void terminate() {
        listener.terminate();
        this.isAlive = false;
        // this doesn't have any purpose really..
    }

    public boolean isAlive() {
        return isAlive;
    }
}