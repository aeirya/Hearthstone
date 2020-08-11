package com.bubble.athena.server.lobby;

import com.bubble.athena.net.lobby.ChatMessage;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;
import com.bubble.net.server.INetwork;

public class ChatSystem {
    private final INetwork net;
    private final IUserManager users;

    public ChatSystem(IUserManager users, INetwork net) {
        this.net = net;
        this.users = users;
    }

    public void send(String from, String to, String msg) {
        if (users.isOnline(to)) {
            net.respond(
                new Response(NetResponse.CHAT_MESSAGE, new ChatMessage(from, to, msg))
                ,users.getOnlineUser(to));
        } else {
            // notify from
        }
    }

}