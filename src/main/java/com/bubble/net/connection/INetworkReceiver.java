package com.bubble.net.connection;

public interface INetworkReceiver {
    void receive(String data);
    void terminate();
}