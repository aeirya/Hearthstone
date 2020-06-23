package com.bubble.hearthstone.net.user.registry;

import com.bubble.hearthstone.net.event.IEventCaller;
import com.bubble.hearthstone.net.user.User;

public interface IUserManager extends IEventCaller {
    boolean login(String username, String password);
    boolean signup(String username, String password);
    boolean delete(String username, String password);
    boolean logout(String username, String password);
    boolean authenticate(String username, String password);
    User getMe();
}