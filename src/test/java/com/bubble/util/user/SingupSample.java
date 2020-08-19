package com.bubble.util.user;

import com.bubble.athena.server.user.UserManager;

public class SingupSample {
    public static void main(String[] args) {
        final UserManager usermanager = new UserManager();
        usermanager.login("aeirya", "ardjo0n1su");
        // usermanager.signup("aeirya", "ardjo0n1su");
        usermanager.login("aeirya", "ardjo0n1su");
    }
}