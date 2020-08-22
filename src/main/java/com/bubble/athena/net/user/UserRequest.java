package com.bubble.athena.net.user;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.athena.server.user.User;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;
import com.google.gson.Gson;


public abstract class UserRequest extends GameRequest implements IUserRequest {

    protected UserRequest(NetRequest type, String username, String password) {
        super(type, new User(username, password));
    }

    public UserRequest(NetRequest type, User user) {
        super(type, user);
    }

    public UserRequest(NetRequest type, String body) {
        super(type, body);
    }

    protected UserRequest(Request request) {
        super(request);
    }

    public User getUser() {
        return new Gson().fromJson(body, User.class);
    }

    @Override
    public Response apply(IServerHandler server) {
        return server.handleUserRequest(this);
    }

    public abstract Response apply(IUserManager manager);
}