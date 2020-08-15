package com.bubble.athena.net.test;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class TestRequest extends GameRequest {

    private String message;

    public TestRequest(String message) {
        super(NetRequest.TEST);
        this.message = message;
    }

    public TestRequest(Request request) {
        super(request);
    }

    @Override
    public Response apply(IServerHandler server) {
        return new Response(NetResponse.OK, "test passed. message: " + message);
    }

}