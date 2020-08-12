package com.bubble.athena.server.lobby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// TODO: test friendship system
class Friendship {
    private final Map<String, List<String>> friendsList;
    private final IOnlineUserQuery usermanager;

    Friendship(IOnlineUserQuery usermanager) {
        this.usermanager = usermanager;
        friendsList = new HashMap<>();
    }

    public void addFriend(String user1, String user2) {
        add(user1, user2);
        add(user2, user1);
    }

    private void add(String to, String user) {
        if(! friendsList.containsKey(to)) friendsList.put(to, new ArrayList<>());
        friendsList.get(to).add(user);
    }

    public List<String> getFriends(String user) {
        return friendsList.get(user);
    }

    public List<String> getOnlineFriends(String user) {
        return getFriends(user)
            .stream()
            .filter(usermanager::isOnline)
            .collect(Collectors.toList());
    }
    
    public boolean isFriendsWith(String user1, String user2) {
        return getFriends(user1).stream().anyMatch(u -> u.equals(user2));
    }
}