package com.bubble.hearthstone.net.server.events.user.errors;

import com.bubble.hearthstone.util.debug.GameError;

public class UserExistsError extends GameError {
    
    public UserExistsError() {
        super("user already exists");
    }
}