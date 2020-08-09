package xoxo.client.net;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

import xoxo.net.response.Response;

public class NetworkService implements INetworkService {
    private final String ip;
    private final int port;
    private Server server;
    private LinkedList<Response> responses;
    private Object lock = new Object();

    public NetworkService(String ip, int port) {
        this.ip = ip;
        this.port = port;
        responses = new LinkedList<>();
    }

    public void connect() {
        connect(ip, port);
    }

    private void connect(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
            server = new Server(this, socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(byte[] data) {
        server.send(data);
    }

    public void send(String data) {
        send(data.getBytes());
    }

    public void disconnect() {
        //
    }

    @Override
    public void receive(byte[] data) {
        responses.add(new Response(data));
        synchronized(lock) {
            lock.notifyAll();
        }
    }

    public Response getNext() {
        synchronized (lock) {
            while (responses.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return responses.removeFirst();
    }
}