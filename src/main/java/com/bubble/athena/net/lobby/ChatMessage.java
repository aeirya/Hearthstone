package com.bubble.athena.net.lobby;

import com.bubble.athena.server.lobby.ILobby;
import com.google.gson.Gson;

public class ChatMessage {
    private final String from;
    private final String to;
    private final String msg;

    public ChatMessage(String from, String to, String msg) {
        this.from = from;
        this.to = to;
        this.msg = msg;
    }

    public ChatMessage(String json) {
        final ChatMessage cm = new Gson().fromJson(json, ChatMessage.class);
        this.from = cm.getFrom();
        this.to = cm.getTo();
        this.msg = cm.getMsg();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getMsg() {
        return msg;
    }

    public void deliver(ILobby lobby) {
        lobby.sendMessage(from, to, msg);
    }

}