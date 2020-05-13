package com.bubble.hearthstone.util.resource;

// import java.awt.Image
import java.util.Map;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.config.Config;
import com.bubble.hearthstone.util.config.ConfigLoader;

public class ResourceManager {
 
    private final Config resourceConfig;

    private final Map<String, CardRecord> cards;
    private final Map<String, User> users;
    
    //TODO: load images here instead?
    // private final Map<String, Image> images

    public ResourceManager(String path) {
        resourceConfig = findConfig(path);
        users = loadUsers();
        cards = loadCards();
    }
    
    private Config findConfig(String path) {
        return ConfigLoader.get(path);
    }

    private Map<String, CardRecord> loadCards() {
        return new CardLoader(resourceConfig).load(); 
    }
    
    public Map<String, CardRecord> getCards() {
        return cards;
    }
    
    private Map<String, User> loadUsers() {
        // return new  
        return null;
    }
    
} 