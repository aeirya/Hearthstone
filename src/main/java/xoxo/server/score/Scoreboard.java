
package xoxo.server.score;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.io.Files;
import com.google.gson.Gson;

import xoxo.net.request.menu.ScorebaordState;
import xoxo.net.request.user.IUserManager;
import xoxo.server.user.OnlineUser;
import xoxo.util.resource.FileLoader;
import xoxo.util.resource.IResourceLoader;

public class Scoreboard {
    private final Map<String, Entry> map;
    private static final String SCORE_DIR = "scores/";

    public Scoreboard() {
        createFolders();
        map = loadEntries();
    }

    private void createFolders() {
        try {
            Files.createParentDirs(new File(SCORE_DIR + "a"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Entry> loadEntries() {
        IResourceLoader<Entry> loader = path -> new Gson().fromJson(new FileLoader().loadFile(path), Entry.class);
        return loader.loadDir(SCORE_DIR);
    }

    private void createUser(String user) {
        map.put(user, new Entry(user));
        save(user);
    }

    public void addRecord(String user, MatchResult result) {
        if (!map.containsKey(user))
            createUser(user);
        map.get(user).add(result);
        save(user);
    }

    public Entry getUserEntry(String name) {
        if (!map.containsKey(name)) createUser(name);
        return map.get(name);
    }

    private void save(String user) {
        try {
            Files.write(new Gson().toJson(map.get(user)).getBytes(), new File(SCORE_DIR + user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Integer> getScoreList() {
        return map.keySet().stream().collect(Collectors.toMap(Function.identity(), user -> map.get(user).getScore()));
    }

    public ScorebaordState getState(OnlineUser user, IUserManager usermanager) {
        return new ScorebaordState(
            getScoreList(), usermanager.getOnlineStatus(), getUserEntry(user.getUsername()), usermanager.getUsersLobbyStatus()
        );
    }

    public static void main(String[] args) {
    Scoreboard sc = new Scoreboard();
        sc.addRecord("arya", MatchResult.WIN);
        sc.addRecord("arya", MatchResult.WIN);
        sc.addRecord("arya", MatchResult.WIN);
        sc.addRecord("b", MatchResult.LOST);
        sc.addRecord("a", MatchResult.WIN);
        sc.addRecord("ali", MatchResult.WIN);
        sc.addRecord("ali", MatchResult.WIN);
        sc.addRecord("ali", MatchResult.WIN);
        sc.addRecord("ahmadalijan", MatchResult.WIN);
        sc.addRecord("ahmadalijan", MatchResult.WIN);
    }
}