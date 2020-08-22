package xoxo.server;

public class ServerMain {
    public static void main(String[] args) {
        final int port = 8000;
        new GameServer(port).run();
    }
}