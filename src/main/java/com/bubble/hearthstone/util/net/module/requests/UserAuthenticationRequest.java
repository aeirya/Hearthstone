package com.bubble.hearthstone.util.net.module.requests;

import com.bubble.hearthstone.net.server.IGameServer;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.Request;

public class UserAuthenticationRequest extends Request {
    
    private final String username;
    private final String password;

    public UserAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public void process(IGameServer server) {
        final boolean result;
        server.handleUserEvent(
            u -> {
                result = u.authenticate(username, password);
            }
        );
        final IResponse response = getResponse(result); 
        server.respond(response);
    }

    private IResponse getResponse(boolean result) {
        return null;
    }
}