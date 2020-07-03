package com.bubble.hearthstone.util.encode;

import com.bubble.hearthstone.net.user.User;

public class UserEncoder {
    
    public EncodedUser encode(String username, String password) {
        return new EncodedUser(
            username,
            encode(password)
            );
    }

    private String encode(String string) {
        return string;
    }

    public User decode(EncodedUser user) {
        return new User(
            user.getUsername(), 
            decode(user.getPassword())
        );
    }

    private String decode(String string) {
        return string;
    }
}