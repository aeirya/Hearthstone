package com.bubble.hearthstone.net.user.registry;

import com.bubble.hearthstone.util.net.module.ClientToken;

public interface IServerUserManager extends IUserManager {
    ClientToken getClientToken(String username, String password);
}