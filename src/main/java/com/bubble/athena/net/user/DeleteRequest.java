package com.bubble.athena.net.user;

import com.bubble.athena.server.user.IUserManager;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class DeleteRequest extends UserRequest {
    
    public DeleteRequest(String username, String password) {
        super(NetRequest.DELETE, username, password);
    }

    @Override
    public Response apply(IUserManager manager) {
        final boolean result = manager.delete(username, password);
        if (result) return new Response(NetResponse.OK, username + " deleted");
        else return new Response(NetResponse.ERROR, "can't remove user: " + username);
    }
}