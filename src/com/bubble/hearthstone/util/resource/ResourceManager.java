package com.bubble.hearthstone.util.resource;

import java.util.Map;

import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.config.ResourceConfig;

public class ResourceManager {
 
    private final ResourceConfig config;
   
    private final Map<String, User> users;

    public ResourceManager(ResourceConfig config) {
        this.config = config;
        createFoldersIfNeeded();
        users = loadUsers();
    }

    private void createFoldersIfNeeded() {
        new FileManager(config).createFoldersIfNeeded();
    }

    private Map<String, User> loadUsers() {
        return new UserLoader().loadDir(config.getUsersFolder());
    }
}