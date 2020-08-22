package com.bubble.athena.net.chat;

import com.bubble.athena.net.lobby.LobbyRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.response.Response;

public class ChatRequest extends LobbyRequest {

    private ChatMessage msg;

    public ChatRequest(ChatMessage msg) {
        super(NetRequest.CHAT_MESSAGE);
        this.msg = msg;
    }

    private ChatMessage getMessage() {
        return msg;
    }

    @Override
    public Response apply(ILobby lobby) {
        return new Response(
            getMessage().deliver(lobby)
        );
    }
    
}