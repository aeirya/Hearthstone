package com.bubble.athena.server.lobby.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatGroup {
    private final List<String> members;
    private final List<String> chatHistory;
    private final int id;

    private static final int LAST_MESSAGES_LIMIT = 100;
    
    public ChatGroup(int id) {
        this.id = id;
        members = new ArrayList<>();
        chatHistory = new ArrayList<>();
    }

    public boolean is(int id) {
        return this.id == id;
    }

    public void addMember(String user) {
        members.add(user);
    }

    public void removeMember(String user) {
        members.remove(user);
    }

    public boolean isMemberOf(String user) {
        return members.contains(user);
    }

    public List<String> getMembers() {
        return members;
    }

    public boolean commitMessage(String from, String msg) {
        chatHistory.add(from + ": " + msg);
        return true;
    }

    public List<String> getMessages() {
        return limit(chatHistory, LAST_MESSAGES_LIMIT);
    }

    private List<String> limit(List<String> list, int len) {
        final int end =  list.size();
        final int from = end < len ? 0 : end - len;
        return list.subList(from, end);
    }
}
