package com.bubble.athena.server.user;

import com.bubble.util.resource.FileLoader;
import com.bubble.util.resource.IResourceLoader;
import com.google.gson.Gson;

public class UserLoader implements IResourceLoader<User> {

    public User loadFile(String path) {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        final Gson gson = new Gson();
        return gson.fromJson(file, User.class);
    }
}