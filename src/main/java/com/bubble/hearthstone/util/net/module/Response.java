package com.bubble.hearthstone.util.net.module;


public class Response implements IResponse {
    
    private final Object data;
    private int id;

    private Response(Object object) {
        this.data = object;
    }

    public static IResponse holdData(Object data) {
        return new Response(data);
    }

    public IResponse setID(int id) {
        this.id = id;
        return this;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Object getData() {
        return data;
    }
}