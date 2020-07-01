package com.bubble.hearthstone.client.framework.util.serialize;

public interface Serializable {

    default String serialize(ISerializer ser) {
        return ser.serialize (this, this.getClass());
    }
}