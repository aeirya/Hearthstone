package xoxo.net.connection;

public interface IConnectionDispatcher {
    void send(byte[] data);
    void connect();
}