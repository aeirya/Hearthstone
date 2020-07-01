package com.bubble.hearthstone.net.user.registry.users;

import com.bubble.hearthstone.net.user.User;

public class Users {

    private Users() { }

    public static final User GUEST = new GuestUser();
    public static final User GLOBAL = new GlobalUser();
    public static final User SERVER = new GlobalUser();
}