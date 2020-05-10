package com.bubble.hearthstone.util.file.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer implements ISerializer {

    private final Gson gson;

    public GsonSerializer() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String serialize(Object obj, Class<?> clazz) {
        return gson.toJson(obj, clazz);
    }
    
    public <T> T deserialize(String string, Class<T> clazz) {
        return gson.fromJson(string, clazz);
    }
}