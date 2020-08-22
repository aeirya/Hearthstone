package com.bubble.net.connection;

public interface IDataReceiver {
    void receive(byte[] data);
    void terminate();
}