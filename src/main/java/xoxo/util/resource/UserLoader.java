package xoxo.util.resource;

import com.google.gson.Gson;

import xoxo.net.request.user.User;

public class UserLoader extends IResourceLoader<User> {

    public User loadFile(String path) {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        final Gson gson = new Gson();
        return gson.fromJson(file, User.class);
    }
}