package xoxo.net.connection;

import xoxo.server.net.Client;
import xoxo.server.net.INetwork;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkListener {
    private boolean isRunning;
    private final ServerSocket serverListener;
    private final INetwork server;
    private final int port;

    public NetworkListener(INetwork server, int port) {
        this.server = server;
        this.port = port;
        serverListener = startServerListener();
    }

    private ServerSocket startServerListener() {
        try {
            return new ServerSocket();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void connectLocal(int port) {
        final String ip = "localhost";
        connect(ip, port);
    }

    private void connect(String ip, int port) {
        try {
            serverListener.bind(new InetSocketAddress(ip, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        new Thread(this::run).start();
    }

    private void run() {
        isRunning = true;
        connectLocal(port);
        while(isRunning) {
            try {
                final Socket socket = serverListener.accept();
                final Client client = new Client(socket, server);
                server.accept(client);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        isRunning = false;
        try {
            serverListener.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}