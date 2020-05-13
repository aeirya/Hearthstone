package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.config.Config;

public class UserLoader extends ResourceLoader<User> {

    public UserLoader(Config resourceConfig) {
        super(resourceConfig);
    }

    protected String getKey() {
        return "users";
    }

    protected User loadResource(String path) {
        // TODO Auto-generated method stub
        return null;
    }
    
}