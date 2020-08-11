package com.bubble.athena.server.lobby.chat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class ChatHistory {
    private final LinkedList<ChatCommit> chats;
    private static final int LIMIT = 30;

    private List<String> globalCache;
    private boolean isGlobalCachedFlag = false;

    ChatHistory() {
        chats = new LinkedList<>();
        globalCache = new ArrayList<>();
    }

    void commit(String from, String to, String msg, boolean isGlobal) {
        chats.add(new ChatCommit(from, to, msg, isGlobal));
        isGlobalCachedFlag = false;
    }

    private boolean owns(String user, ChatCommit c) {
        return c.getFrom().equals(user) || c.getTo().equals(user);
    }

    List<String> getAllOfUserChat(String user) {
        return chats.stream()
            .filter(c -> owns(user, c))
            .map(ChatCommit::toString)
            .collect(Collectors.toList());
    }

    List<String> getUserChat(String user) {
        return limit(getAllOfUserChat(user), LIMIT);
    }

    List<String> getAllGlobal() {
        return chats
        .stream()
        .filter(ChatCommit::isGlobal)
        .map(ChatCommit::toString)
        .collect(Collectors.toList());
    }

    List<String> getGlobalChat() {
        if(isGlobalCachedFlag) {
            return globalCache;
        } else {
            return cached(limit(getAllGlobal(), LIMIT));
        }
    }
    
    private List<String> limit(List<String> list, int len) {
        final int end =  list.size();
        final int from = end < len ? 0 : end - len;
        return list.subList(from, end);
    }

    private List<String> cached(List<String> global) {
        if (! isGlobalCachedFlag) {
            globalCache = global;
            isGlobalCachedFlag = true;
        }
        return global;
    }
}
