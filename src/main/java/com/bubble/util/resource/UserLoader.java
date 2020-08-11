package com.bubble.util.resource;

import com.google.gson.Gson;

import com.bubble.athena.server.user.User;

public class UserLoader implements IResourceLoader<User> {

    public User loadFile(String path) {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        final Gson gson = new Gson();
        return gson.fromJson(file, User.class);
    }
}