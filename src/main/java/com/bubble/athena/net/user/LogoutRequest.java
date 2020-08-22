package com.bubble.athena.net.user;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class LogoutRequest extends UserRequest {
    
    public LogoutRequest(String username, String password) {
        super(NetRequest.LOGOUT, username, password);
    }

    @Override
    public Response apply(IUserManager manager) {
        final boolean result = manager.logout(username, password);
        if (result) return new Response(NetResponse.OK, username + " logged out");
        else return new Response(NetResponse.ERROR, "no such online user");
    }
}
