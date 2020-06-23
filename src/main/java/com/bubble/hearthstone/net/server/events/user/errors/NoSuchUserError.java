package com.bubble.hearthstone.net.server.events.user.errors;

import com.bubble.hearthstone.util.debug.GameError;

public class NoSuchUserError extends GameError {

    public NoSuchUserError() {
        super(
            "no such user exists"
        );
    }
    
}