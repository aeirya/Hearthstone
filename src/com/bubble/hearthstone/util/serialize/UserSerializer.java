package com.bubble.hearthstone.util.serialize;

import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.encode.EncodedUser;

public class UserSerializer extends GsonSerializer {

    public String serialize(User user) {
        return serialize( user.encode() , EncodedUser.class);
    }

    public User deserialize(String string) {
        final EncodedUser encodedUser = deserialize(string, EncodedUser.class);
        return encodedUser.toUser();
    }

    public String encode(String password) {
        return password;
    }
}