package xoxo.client;

// import xoxo.client.ui.CliGraphics;

public class ClientMain {
    public static void main(String[] args) {
        final String ip = "localhost";
        final int port = 8000;
        GameClient client = new GameClient(ip, port);
        client.run();
        // new CliGraphics(client.get());
    }
}