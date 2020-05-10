package com.bubble.hearthstone.util.file.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class GsonSerializer implements ISerializer {

    private final Gson gson;

    public GsonSerializer() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String serialize(Object obj, Type type) {
        return gson.toJson(obj, type);
    }
    
    // public <T> T deserialize(String string, Type type) {
    //     return gson.fromJson(string, type);
    // }
}