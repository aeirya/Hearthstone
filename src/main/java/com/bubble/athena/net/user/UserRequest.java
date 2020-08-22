package com.bubble.athena.net.user;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.response.Response;


public abstract class UserRequest extends GameRequest implements IUserRequest {

    protected String username;
    protected String password;

    protected UserRequest(NetRequest type, String username, String password) {
        super(type);
        this.username = username;
        this.password = password;
    }

    @Override
    public Response apply(IServerHandler server) {
        return server.handleUserRequest(this);
    }

    public abstract Response apply(IUserManager manager);
}