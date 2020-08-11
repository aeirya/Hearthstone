package com.bubble.athena.net.chat;

import com.bubble.athena.net.lobby.LobbyRequest;
import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

// maybe i could split this from lobby
public class GetChatHistoryRequest extends LobbyRequest {

    public GetChatHistoryRequest(Request request) {
        super(request);
    }

    public GetChatHistoryRequest(String user) {
        super(NetRequest.GET_CHATS, user);
    }

    public GetChatHistoryRequest() {
        super(NetRequest.GET_GLOBAL_CHAT, null);
    }

    @Override
    public Response apply(ILobby lobby) {
        if(NetRequest.valueOf(type) == NetRequest.GET_CHATS) {
            return new Response(
                NetResponse.OK, 
                lobby.getUserChat(body)
            );

        } else {
            return new Response(
                NetResponse.OK, 
                lobby.getGlobalChat()
            );
        }
    }
}