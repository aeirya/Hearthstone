package com.bubble.athena.server.lobby.chat;

public class ChatCommit {
    private final String from;
    private final String to;
    private final String msg;
    private final boolean isGlobal;

    ChatCommit(String from, String to, String msg, boolean isGlobal) {
        this.from = from;
        this.to = to;
        this.msg = msg;
        this.isGlobal = isGlobal;
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

    public boolean isGlobal() {
        return isGlobal;
    }
    
    public String toString() {
        return from + ": " + msg;
    }
    
}