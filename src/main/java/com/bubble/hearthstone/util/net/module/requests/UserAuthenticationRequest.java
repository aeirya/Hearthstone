package com.bubble.hearthstone.util.net.module.requests;

import com.bubble.hearthstone.util.net.module.ClientToken;
import com.bubble.hearthstone.util.net.module.IGameServer;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IRequestHandler;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.Request;

public class UserAuthenticationRequest extends Request {

    private final String username;
    private final String password;

    public UserAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void process(IGameServer server) {
        final boolean result;
        server.handleUserEvent(u -> {
            u.authenticate(username, password);
        });
        // final IResponse response = getResponse(result);
        // server.respond(response);
    }

    private IResponse getResponse(boolean result) {
        return null;
    }

    @Override
    public void addToken(ClientToken token) {
        // TODO Auto-generated method stub

    }

    @Override
    public ClientToken getToken() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IResponse process(IRequestHandler server) {
        // TODO Auto-generated method stub
        return null;
    }
}