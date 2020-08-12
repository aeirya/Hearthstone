package com.bubble.athena.server.lobby.group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bubble.athena.server.lobby.chat.ChatGroup;

public class GroupManager {
    private final List<ChatGroup> groups;
    private final GroupCreator gmaker;

    public GroupManager() {
        groups = new ArrayList<>(); // i could be loading groups
        gmaker = new GroupCreator(groups);
    }

    public ChatGroup createGroup() {
        return gmaker.createGroup();
    }

    public boolean commit(int groupId, String from, String msg) {
        return get(groupId).commitMessage(from, msg);
    }

    public ChatGroup get(int id) {
        return groups.stream().filter(g -> g.is(id)).findAny().orElse(null);
    }

    public List<ChatGroup> getUserGroups(String user) {
        return groups.stream().filter(g -> g.isMemberOf(user)).collect(Collectors.toList());
    }
}