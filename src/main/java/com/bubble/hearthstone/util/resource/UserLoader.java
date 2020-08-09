package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.net2.user.User;
import com.bubble.hearthstone.util.serialize.UserSerializer;

public class UserLoader extends ResourceLoader<User> {

    public User loadFile(String path) {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        final UserSerializer ser = new UserSerializer();
        return ser.deserialize(file);
    }
}