package com.bubble.hearthstone.util.net.module;

import com.bubble.hearthstone.net.server.IRequestHandler;
import com.bubble.hearthstone.net.user.registry.IServerUserManager;

public interface IUserRequest extends IRequestAction {
    default IResponse process(IRequestHandler server) {
        return server.handleUserRequest(this);
    }

    IResponse process(IServerUserManager manager);
}