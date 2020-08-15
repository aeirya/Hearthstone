package com.bubble.athena.net.user;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class LoginRequest extends UserRequest {

    public LoginRequest(String username, String password) {
        super(NetRequest.LOGIN, username, password);
    }

    public Response apply(IUserManager manager) {
        final boolean result = manager.login(username, password);
        if (result) {
            manager.getOnlineUser(username).setAuth(getAuth());
            return new Response(NetResponse.OK, "hi " + username);
        } else {
            return new Response(NetResponse.ERROR, "can't sign you in");
        }
    }
}