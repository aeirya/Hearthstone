package com.bubble.athena.net.friendship;

import com.bubble.athena.net.lobby.LobbyRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;
import com.google.gson.Gson;

public class AddFriendRequest extends LobbyRequest {

    public AddFriendRequest(Request request) {
        super(request);
    }

    public AddFriendRequest(String json) {
        super(json);
    }

    public AddFriendRequest(String me, String them) {
        this(new FriendshipMessage(me, them));
    }

    public AddFriendRequest(FriendshipMessage inv) {
        super(NetRequest.ADD_FRIEND, inv);
    }

    private FriendshipMessage getMessage() {
        return new Gson().fromJson(body, FriendshipMessage.class);
    }

    @Override
    public Response apply(ILobby lobby) {
        final FriendshipMessage inv = getMessage();
        lobby.addFriend(inv.getMe(), inv.getThem());
        return Response.OK;
    }
    
}