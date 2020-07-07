package com.bubble.hearthstone.util.resource;

import java.util.Map;

import com.bubble.hearthstone.model.card.Card;
import com.bubble.hearthstone.module.gui.components.IImage;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.config.GameConfig;
import com.bubble.hearthstone.util.config.ResourceConfig;

public class ResourceManager {
 
    private final ResourceConfig config;
    
    private final Map<String, User> users;
    private final Map<String, IImage> images;
    private final Map<String, Card> cards;

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
        cards = loadCards();
        images = loadImages();
        gameConfig = loadGameConfig();
    }

    private void createFoldersIfNeeded() {
        new FileManager(config).createFoldersIfNeeded();
    }

    private Map<String, User> loadUsers() {
        // return new UserLoader().loadDir(config.getUsersFolder());
        return null;
    }

    private Map<String, IImage> loadImages() {
        // later: have a list of to be laoded image 
        // return new ImageLoader().loadDir(DATA_PATH + resourceConfig.getProperty("image"));
        return null;
    }

    public IImage getImage(String name) {
        return images.get(name);
    }

    private Map<String, Card> loadCards() {
        // return new CardLoader().loadDir(DATA_PATH + resourceConfig.getProperty("cards"));
        return null;
    }
    
    public Map<String, Card> getCards() {
        return cards;
    }

    public ResourceConfig getResourceConfig() {
        return config;
    }

    private GameConfig loadGameConfig() {
        return new GameConfig(config);
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }
}