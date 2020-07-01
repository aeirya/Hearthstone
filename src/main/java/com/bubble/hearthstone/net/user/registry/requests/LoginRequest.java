package com.bubble.hearthstone.net.user.registry.requests;

import com.bubble.hearthstone.net.user.registry.IServerUserManager;
import com.bubble.hearthstone.util.net.module.IResponse;

public class LoginRequest extends UserRequest {

    public LoginRequest(String username, String password) {
        super(username, password);
    }

    public IResponse process(IServerUserManager manager) {
        return respond(
            manager.login(username, password)
        );
    }
}