package xoxo.client.net;

import xoxo.net.response.Response;

public interface INetworkService {
    void connect();
    void send(byte[] data);
    void send(String data);
    void receive(byte[] data);
    Response getNext();
}