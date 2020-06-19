package com.bubble.hearthstone.util.net.module;

import com.bubble.hearthstone.net.server.IRequestHandler;

public interface IRequest {
    void setID(int id);
    void addToken(ClientToken token);
    ClientToken getToken();
    IResponse process(IRequestHandler server);
}