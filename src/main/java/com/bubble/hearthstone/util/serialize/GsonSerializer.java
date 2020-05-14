package com.bubble.hearthstone.util.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer implements ISerializer {

    protected final Gson gson;

    public GsonSerializer() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /** registers type adapter for the clazz with an implementation of it */
    public GsonSerializer(Class<?> clazz, Object object) {
        gson = new GsonBuilder()
                .registerTypeAdapter(clazz, object)
                .setPrettyPrinting()
                .create();
    }

    public String serialize(Object obj, Class<?> clazz) {
        return gson.toJson(obj, clazz);
    }
    
    public <T> T deserialize(String string, Class<T> clazz) {
        return gson.fromJson(string, clazz);
    }
}