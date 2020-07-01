package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.net.user.UserSave;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Image;
import java.util.Map;
import java.util.Properties;

public class ResourceManager {

    private static final String DATA_PATH = "data/";
    private final Properties resourceConfig;

    private final Map<String, CardRecord> cards;
    private final Map<String, User> users;
    private final Map<String, Image> images;

    public ResourceManager(Properties resourceConfig) {
        this.resourceConfig = resourceConfig;
        createFoldersIfNeeded();
        users = loadUsers();
        images = loadImages();
        cards = loadCards();
    }

    public UserSave loadSave(User user) {
        return new JsonLoader().load(
            DATA_PATH + resourceConfig.getProperty("save") + user.getUsername() + ".save", UserSave.class
            );
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

    private Map<String, Image> loadImages() {
        return new ImageLoader().loadDir(DATA_PATH + resourceConfig.getProperty("image"));
    }
    
    public Image getImage(String name) {
        return images.get(name);
    }

    public String getLogPath() {
        return DATA_PATH + resourceConfig.getProperty("logs");
    }
    
    public String getResource(String resource) {
        return DATA_PATH + resourceConfig.getProperty(resource);
    }
    //start using this in ur code instead
} 