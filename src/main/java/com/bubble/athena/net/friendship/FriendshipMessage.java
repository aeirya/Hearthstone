package com.bubble.athena.net.friendship;

class FriendshipMessage {
    private final String me;
    private final String them;
    private final String msg;

    public FriendshipMessage(String me, String them) {
        this.me = me;
        this.them = them;
        msg = "";
    }

    public String getMe() {
        return me;
    }

    public String getThem() {
        return them;
    }

    public String getMsg() {
        return msg;
    }

    
}