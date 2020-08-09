package com.bubble.hearthstone.util.serialize;

import com.bubble.hearthstone.net2.user.User;

public class EncodedUser implements Serializable {

    private final String username;
    private final String pazzword;

    public EncodedUser(User user) {
        this.username = user.getUsername();
        this.pazzword = user.getEncodedPassword();
    }

    public User getUser() {
        return new User(
            username, decode(pazzword)
        );
    }

    private String decode(String word) {
        return word;
    }
}