package com.bubble.hearthstone.util.net.module;

public interface IResponse {
    IResponse setID(int id);

    int getID();
    Object getData();
}