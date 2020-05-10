package com.bubble.hearthstone.util.file.serialize;

import java.lang.reflect.Type;

import com.google.common.reflect.TypeToken;

public interface ISerializer {
    
    String serialize(Object obj, Type type);
    
    // T deserialize(String string, Type type);
    
    default <T> String serialize(Serializable<T> obj) {
        return obj.serialize(this);
    }

    // default void 


    // default String serialize(Object obj) {
    //     return serialize(
    //         obj, 
    //         TypeToken.of(obj.getClass()).getType()
    //     );
    // }

    // default T deserialize(String string, Class<T> clazz) {
    //     return deserialize(string, TypeToken.of(clazz).getType());
    // }

    // default T deserialize (String string) {
    //     return deserialize(
    //         string, null
    //     );
    // }
}