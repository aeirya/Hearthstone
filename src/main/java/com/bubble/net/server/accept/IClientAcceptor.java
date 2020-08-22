package com.bubble.net.server.accept;

import java.net.Socket;

public interface IClientAcceptor {
    void accept(Socket socket);
}