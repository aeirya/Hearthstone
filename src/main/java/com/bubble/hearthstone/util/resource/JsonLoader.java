package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.util.serialize.GsonSerializer;
import com.bubble.hearthstone.util.serialize.ISerializer;

public class JsonLoader {

    public <T> T load(String path, Class<T> clazz)
    {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        final ISerializer ser = new GsonSerializer();
        return ser.deserialize(file, clazz);
    }
}