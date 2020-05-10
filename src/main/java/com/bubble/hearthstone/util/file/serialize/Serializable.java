package com.bubble.hearthstone.util.file.serialize;

import java.lang.reflect.Type;
import com.google.common.reflect.TypeToken;

public interface Serializable <T> {

    default String serialize(ISerializer ser) {
        return ser.serialize (this, getType());
    }

    default Type getType() {
        // return new TypeToken<T>() { private static final long serialVersionUID = 1L; }
        //     .getType();
        return new TypeToken<T>(getClass()).getType();
    }
}