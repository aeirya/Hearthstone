package com.bubble.hearthstone.net.server.events.user.errors;

import com.bubble.hearthstone.util.debug.GameError;

public class WrongPasswordError extends GameError {
    
    public WrongPasswordError() {
        super("wrong password");
    }
}