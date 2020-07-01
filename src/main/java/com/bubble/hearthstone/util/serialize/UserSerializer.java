package com.bubble.hearthstone.util.serialize;

import com.bubble.hearthstone.net.user.User;

public class UserSerializer extends GsonSerializer {

    public static void main(String[] args) {
        UserSerializer ser = new UserSerializer();
        User user = new User("aeirya", "hi");
        User user2 = ser.deserialize(
            ser.serialize(user)
        );
        System.out.println(user2);
    }

    public String serialize(User user) {
        return serialize( new EncodedUser(user) , EncodedUser.class);
    }

    public User deserialize(String string) {
        final EncodedUser encodedUser = deserialize(string, EncodedUser.class);
        return encodedUser.getUser();
    }

    public String encode(String password) {
        return password;
    }
}