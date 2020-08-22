package com.bubble.athena.net.chat;

import com.bubble.athena.server.lobby.ILobby;

public class ChatMessage {
    private final String from;
    private final String to;
    private final String msg;
    private final boolean isGlobal;

    public ChatMessage(String from, String msg) {
        this.from = from;
        this.msg = msg;
        to = "";
        isGlobal = true;
    }

    public ChatMessage(String from, String to, String msg) {
        this.from = from;
        this.to = to;
        this.msg = msg;
        isGlobal = false;
    }

    public boolean deliver(ILobby lobby) {
        return lobby.sendMessage(from, to, msg, isGlobal);
    }
}