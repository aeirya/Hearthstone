package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.util.serialize.GsonSerializer;
import com.bubble.hearthstone.util.serialize.ISerializer;

public class JsonLoader <T> extends ResourceLoader <T> {

    public T loadFile(String path, Class<T> clazz)
    {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        final ISerializer ser = new GsonSerializer();
        return ser.deserialize(file, clazz);
    }
    
    /** don't use this, use loadfile(String string, Class<T> clazz) instead
     * @return null **/
    public T loadFile(String path) {
        return null;
    }
}