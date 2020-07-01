package com.bubble.hearthstone.util.net.module.requests;

import com.bubble.hearthstone.net.server.IRequestHandler;
import com.bubble.hearthstone.util.net.module.IRequestAction;
import com.bubble.hearthstone.util.net.module.IResponse;

//TODO: use this
public class UserAuthenticationRequest implements IRequestAction {
    
    private final String username;
    private final String password;

    public UserAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public IResponse process(IRequestHandler server) {
        return server.handleUserRequest(
            u -> {
                final Boolean result = u.authenticate(username, password);
                return getResponse(result);
            }
        );
    }

    private IResponse getResponse(boolean result) {
        return null;
    }
}