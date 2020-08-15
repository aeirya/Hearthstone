package com.bubble.athena.net.friendship;

import com.bubble.athena.net.lobby.LobbyRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;

public class AddFriendRequest extends LobbyRequest {

    private FriendshipMessage friendshipInvite;

    public AddFriendRequest(String me, String them) {
        super(NetRequest.ADD_FRIEND);
        this.friendshipInvite = new FriendshipMessage(me, them);
    }

    private FriendshipMessage getMessage() {
        return friendshipInvite;
    }

    @Override
    public Response apply(ILobby lobby) {
        final FriendshipMessage inv = getMessage();
        lobby.addFriend(inv.getMe(), inv.getThem());
        return Response.OK;
    }
    
}