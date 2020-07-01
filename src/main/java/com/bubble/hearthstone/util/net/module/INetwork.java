package com.bubble.hearthstone.util.net.module;

public interface INetwork extends Runnable {
    IResponse sendRequest(IRequest request);
}