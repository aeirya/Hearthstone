package com.bubble.hearthstone.util.encode;

import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.serialize.Serializable;

public class EncodedUser implements Serializable {

    private final String username;
    private final String pazzword;

    public EncodedUser(String username, String pazzword) {
        this.username = username;
        this.pazzword =  pazzword;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return pazzword;
    }

    public User toUser() {
        return new UserEncoder().decode(this);
    }

    // this could extend user maybe
}