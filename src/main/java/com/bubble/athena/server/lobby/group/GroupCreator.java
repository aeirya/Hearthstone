package com.bubble.athena.server.lobby.group;

import java.util.List;
import java.util.stream.IntStream;

import com.bubble.athena.server.lobby.chat.ChatGroup;

public class GroupCreator {
    private final List<ChatGroup> groups;
    private int index = -1;

    public GroupCreator(List<ChatGroup> groups) {
        this.groups = groups;
    }

    public ChatGroup createGroup() {
        return new ChatGroup(findNextIndex());
    }

    private int findNextIndex() {
        return IntStream.generate(this::next).filter(this::checkIndex).findFirst().orElse(-1);
    }

    private int next() {
        return ++index;
    }

    private boolean checkIndex(int i) {
        return groups.stream().noneMatch(g -> g.is(i));
    }
}