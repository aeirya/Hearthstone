package com.bubble.athena.net.test;

import com.bubble.athena.net.chat.ChatMessage;
import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.athena.server.ServiceLocator;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;

public class TestCustomRequest extends GameRequest {
    private String myname;
    private ChatMessage c;

    public TestCustomRequest(String myname, ChatMessage c) {
        super(NetRequest.COSTUM1);
        this.myname = myname;
        this.c = c;
    }

    public TestCustomRequest(Request request) {
        super(request);
    }

    public TestCustomRequest(String json) {
        super(json);
    }

    @Override
    public Response apply(IServerHandler handler) {
        ServiceLocator.getLogger().log("test request");
        return Response.OK;
    }
}