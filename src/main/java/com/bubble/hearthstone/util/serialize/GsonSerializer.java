package com.bubble.hearthstone.util.serialize;

import com.google.gson.GsonBuilder;

public class GsonSerializer implements ISerializer {

    private final GsonBuilder gson;

    public GsonSerializer() {
        gson = new GsonBuilder().setPrettyPrinting();
    }

    /** registers type adapter for the clazz with an implementation of it */
    public GsonSerializer(Class<?> clazz, Object object) {
        gson = new GsonBuilder()
                .registerTypeAdapter(clazz, object)
                .setPrettyPrinting();
    }
    
    public GsonBuilder registerTypeAdapter(Class<?> clazz, Object object) {
        return gson.registerTypeAdapter(clazz, object);
    }

    public String serialize(Object obj, Class<?> clazz) {
        return gson.create().toJson(obj, clazz);
    }
    
    public <T> T deserialize(String string, Class<T> clazz) {
        return gson.create().fromJson(string, clazz);
    }
}