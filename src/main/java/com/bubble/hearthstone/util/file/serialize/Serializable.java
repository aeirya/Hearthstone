package com.bubble.hearthstone.util.file.serialize;


public interface Serializable {

    default String serialize(ISerializer ser) {
        return ser.serialize (this, this.getClass());
    }
    
}