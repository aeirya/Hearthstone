package com.bubble.athena.server.lobby;

import java.util.List;

import com.bubble.athena.server.lobby.chat.ChatSystem;
import com.bubble.athena.server.lobby.group.GroupManager;
import com.bubble.athena.server.lobby.match.MatchFinder;
import com.bubble.athena.server.lobby.match.MatchRequestDispatcher;
import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.server.INetwork;

public class Lobby implements ILobby {
    private final MatchFinder matchFinder;
    private final MatchRequestDispatcher matchRequestDispatcher;
    private final ChatSystem chat;
    private final Friendship friends;
    private final GroupManager groups;
    private final IOnlineUserQuery usermanager;

    public Lobby(IOnlineUserQuery usermanager, INetwork net) {
        this.usermanager = usermanager;
        friends = new Friendship(usermanager);
        chat = new ChatSystem(usermanager);
        matchFinder = new MatchFinder(usermanager, net);
        matchRequestDispatcher = new MatchRequestDispatcher(usermanager);
        groups = new GroupManager();
    }

    @Override
    public void findMatch(String user) {
        matchFinder.queue(user);
    }

    public void startMatch(String u1, String u2) {
        matchFinder.match(getUser(u1), getUser(u2));
    }

    private OnlineUser getUser(String user) {
        return usermanager.getOnlineUser(user);
    }

    public boolean matchRequest(String from, String to) {
        return matchRequestDispatcher.request(from, to);
    }

    // chat delegates

    @Override
    public boolean sendMessage(String from, String to, String msg, boolean isGlobal) {
        return chat.send(from, to, msg, isGlobal);
    }

    public boolean sendGroupMessage(String from, String msg, int groupID) {
        return groups.commit(groupID, from, msg);
    }
    
    public List<String> getGlobalChat() {
        return chat.getGlobalChat();
    }

    @Override
    public List<String> getUserChat(String user) {
        return chat.getUserChat(user);
    }

    // friendship delegates

    public void addFriend(String user1, String user2) {
        friends.addFriend(user1, user2);
    }

    public List<String> getFriends(String user) {
        return friends.getFriends(user);
    }

    public List<String> getOnlineFriends(String user) {
        return friends.getOnlineFriends(user);
    }

    public boolean isFriendsWith(String user1, String user2) {
        return friends.isFriendsWith(user1, user2);
    }

}