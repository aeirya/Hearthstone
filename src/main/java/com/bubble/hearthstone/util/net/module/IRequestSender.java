package com.bubble.hearthstone.util.net.module;

public interface IRequestSender {
    IResponse request(IRequest request);
}