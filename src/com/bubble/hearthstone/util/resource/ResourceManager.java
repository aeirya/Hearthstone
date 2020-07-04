package com.bubble.hearthstone.util.resource;

import java.util.Map;

import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.config.GameConfig;
import com.bubble.hearthstone.util.config.ResourceConfig;

public class ResourceManager {
 
    private final ResourceConfig config;
    
    private final Map<String, User> users;
    private final GameConfig gameConfig;

    public ResourceManager(String configPath) {
        this(
            new ResourceConfig(configPath)
        );
    }

    public ResourceManager(ResourceConfig config) {
        this.config = config;
        createFoldersIfNeeded();
        users = loadUsers();
        gameConfig = loadGameConfig();
    }

    private void createFoldersIfNeeded() {
        new FileManager(config).createFoldersIfNeeded();
    }

    private Map<String, User> loadUsers() {
        // return new UserLoader().loadDir(config.getUsersFolder());
        return null;
    }

    private GameConfig loadGameConfig() {
        return new GameConfig(config);
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }
}