package com.bubble.athena.net.user;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class LoginRequest extends UserRequest {

    public LoginRequest(String username, String password) {
        super(NetRequest.LOGIN, new User(username, password));
    }

    public LoginRequest(String body) {
        super(NetRequest.LOGIN, body);
    }

    public LoginRequest(Request request) {
        super(request);
    }

    public Response apply(IUserManager manager) {
        final User user = getUser();
        final String username = user.getName();
        final String password = user.getPassword();
        final boolean result = manager.login(username, password);
        if (result) {
            manager.getOnlineUser(username).setAuth(getAuth());
            return new Response(NetResponse.OK, "hi " + username);
        } else {
            return new Response(NetResponse.ERROR, "can't sign you in");
        }
    }

}