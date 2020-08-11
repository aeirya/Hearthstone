package com.bubble.athena.net.lobby;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;

public class ChatRequest extends LobbyRequest {

    public ChatRequest(ChatMessage msg) {
        super(NetRequest.CHAT_MESSAGE, msg);
    }

    public ChatRequest(Request request) {
        super(request);
    }

    private ChatMessage getMessage() {
        return new ChatMessage(body);
    }

    @Override
    public Response apply(ILobby lobby) {
        getMessage().deliver(lobby);
        return Response.OK;
    }
    
}