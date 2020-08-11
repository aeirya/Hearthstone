package com.bubble.athena.net.chat;

import com.bubble.athena.server.lobby.ILobby;
import com.google.gson.Gson;

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

    public ChatMessage(String json) {
        final ChatMessage cm = new Gson().fromJson(json, ChatMessage.class);
        this.from = cm.getFrom();
        this.to = cm.getTo();
        this.msg = cm.getMsg();
        this.isGlobal = cm.getIsGlobal();
    }

    private String getFrom() {
        return from;
    }

    private String getTo() {
        return to;
    }

    private String getMsg() {
        return msg;
    }

    private boolean getIsGlobal() {
        return isGlobal;
    }

    public boolean deliver(ILobby lobby) {
        return lobby.sendMessage(from, to, msg, isGlobal);
    }
}