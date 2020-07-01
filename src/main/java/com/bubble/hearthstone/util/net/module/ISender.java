package com.bubble.hearthstone.util.net.module;

public interface ISender {
    IResponse send(IRequest request);
    boolean checkResponse(IResponse response);
}