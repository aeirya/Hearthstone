package com.bubble.athena.net.score;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bubble.athena.server.score.Entry;
import com.google.gson.Gson;

public class ScoreboardState {
    
    private List<ScoreRow> scores;
    private Entry me;

    public ScoreboardState(Map<String, Integer> scores, Map<String, Boolean> onlineStatus, Entry me, Map<String, String> status) {
        this.scores = makeScoreboard(scores, onlineStatus, status);
        this.me = me;
        hightlightMe();
    }

    private void hightlightMe() {
        final ScoreRow myRow = scores.stream().filter(s-> s.getUser().equals(me.getUser())).findAny().orElse(null);
        if(myRow != null) myRow.highlight();
    }

    public ScoreboardState(String json) {
        final ScoreboardState state = new Gson().fromJson(json, ScoreboardState.class);
        this.scores = state.scores;
        this.me = state.me;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    private List<ScoreRow> makeScoreboard(Map<String, Integer> scores, Map<String, Boolean> onlineStatus, Map<String, String> status) {
        return scores
            .keySet()
            .stream()
            .map(user -> new ScoreRow(user, scores.get(user), onlineStatus.getOrDefault(user, false), status.getOrDefault(user, "offline")))
            .collect(Collectors.toList());
    }

    public List<ScoreRow> getOnline() {
        return filterByOnline(true);
    }

    public List<ScoreRow> getOffline() {
        return filterByOnline(false);
    }

    private List<ScoreRow> filterByOnline(boolean online) {
        return scores
            .stream()
            .filter(user -> user.isOnline() == online)
            .sorted((a,b) -> b.getScore() - a.getScore())
            .collect(Collectors.toList());
    }

    public Entry getMe() {
        return me;
    }
}