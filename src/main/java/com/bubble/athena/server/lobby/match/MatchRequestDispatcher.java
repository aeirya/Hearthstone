package com.bubble.athena.server.lobby.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.bubble.athena.server.lobby.IOnlineUserQuery;

public class MatchRequestDispatcher {
    private IOnlineUserQuery usermanager;
    private Map<String, List<String>> requests;

    public MatchRequestDispatcher(IOnlineUserQuery usermanager) {
        this.usermanager = usermanager;
    }

    public boolean request(String from, String to) {
        if(! usermanager.isOnline(to)) return false;
        if(requests.get(to).contains(from)) return false;
        addRequest(from, to);
        return true;
    }

    private void addRequest(String from, String to) {
        if (! requests.containsKey(from)) requests.put(to, new ArrayList<>());
        requests.get(from).add(to);
    }

    public List<String> getMatchRequests(String to) {
        return requests.get(to);
    }

    public List<String> getPendingSentRequests(String from) {
        return requests
            .entrySet()
            .stream()
            .filter(e -> e.getValue().contains(from))
            .map(Entry::getKey)
            .collect(Collectors.toList()); 
    }
}