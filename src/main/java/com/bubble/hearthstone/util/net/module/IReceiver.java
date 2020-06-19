package com.bubble.hearthstone.util.net.module;

public interface IReceiver extends Runnable {
    IResponse getNext();
}