package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.util.serialize.CardSerializer;
import com.bubble.hearthstone.util.serialize.ISerializer;

public class JsonLoader {

    public <T> T load(String path, Class<T> clazz)
    {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        //i will be needing to change the implementation given to the serializer later
        final ISerializer ser = new CardSerializer(); //to prevent the loading decks bug
        return ser.deserialize(file, clazz);
    }
}