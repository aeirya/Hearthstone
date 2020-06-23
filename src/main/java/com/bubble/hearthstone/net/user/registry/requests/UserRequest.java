package com.bubble.hearthstone.net.user.registry.requests;

import com.bubble.hearthstone.net.server.IRequestHandler;
import com.bubble.hearthstone.net.user.registry.IServerUserManager;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.Request;
import com.bubble.hearthstone.util.net.module.Response;

public abstract class UserRequest extends Request {
    
    protected final String username;
    protected final String password;

    UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public IResponse process(IRequestHandler server) {
        return server.handleUserRequest(this);
    }

    public abstract IResponse process(IServerUserManager manager);

    protected IResponse respond(Object data) {
        return Response.holdData(data);
    }
}