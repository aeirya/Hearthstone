package com.bubble.hearthstone.client.framework.util.serialize;

public interface ISerializer {
    
    String serialize(Object obj, Class<?> clazz);
    
    <T> T deserialize(String string, Class<T> clazz);
    
    default String serialize(Serializable obj) {
        return obj.serialize(this);
    }
}