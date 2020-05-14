package com.bubble.hearthstone.util.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// import java.awt.Image
import java.util.Map;
import java.util.Properties;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.config.ConfigLoader;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class ResourceManager {

    private static final String DATA_PATH = "data/";
    private final Properties resourceConfig;

    private final Map<String, CardRecord> cards;
    private final Map<String, User> users;

    // private final Map<String, Image> images
    // phase2: load images here instead?

    public ResourceManager(String path) {
        resourceConfig = findConfig(path);
        createFoldersIfNeeded();
        users = loadUsers();
        cards = loadCards();
    }

    private void createFoldersIfNeeded() {
        resourceConfig.values().forEach(
            v -> {
                try {
                    Files.createDirectories(Paths.get(DATA_PATH + (String) v));
                } catch (IOException e) {
                    ServiceLocator.getLogger().error(this, e);
                }
            }
        );
    }
    
    private Properties findConfig(String path) {
        return new ConfigLoader().loadFile(
            this.getClass().getClassLoader().getResource(path).getFile()
        );
    }

    private Map<String, CardRecord> loadCards() {
        return new CardLoader().loadDir(DATA_PATH + resourceConfig.getProperty("cards"));
    }
    
    public Map<String, CardRecord> getCards() {
        return cards;
    }
    
    private Map<String, User> loadUsers() {
        return new UserLoader().loadDir(DATA_PATH + resourceConfig.getProperty("users"));
    }

    public Map<String, User> getUsers() {
        return users;
    }
    
    public String getResource(String resource) {
        return DATA_PATH + resourceConfig.getProperty(resource);
    }

    public String getLogPath() {
        return DATA_PATH + resourceConfig.getProperty("logs");
    }
} 