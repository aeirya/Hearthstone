package com.bubble.hearthstone.net.user.registry.requests;

import com.bubble.hearthstone.net.user.registry.IServerUserManager;
import com.bubble.hearthstone.util.net.module.IResponse;

public class GetTokenRequest extends UserRequest {

    public GetTokenRequest(String username, String password) {
        super(username, password);
    }

    @Override
    public IResponse process(IServerUserManager manager) {
        return respond(manager.getClientToken(username, password));
    }
}