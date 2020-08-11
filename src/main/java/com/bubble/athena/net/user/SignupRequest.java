package com.bubble.athena.net.user;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class SignupRequest extends UserRequest {

    public SignupRequest(String username, String password) {
        super(NetRequest.REGISTER, new User(username, password));
    }

    public SignupRequest(Request request) {
        super(request);
    }

    @Override
    public Response apply(IUserManager manager) {
        final User user = getUser();
        final String username = user.getName();
        final String password = user.getPassword();
        final boolean result = manager.signup(username, password);
        if (result) return new Response(NetResponse.OK, username + " signed up successfully");
        else return new Response(NetResponse.ERROR, "can't resgister user: " + username);
    }
    
}