package com.bubble.hearthstone.message;

public interface IMessage {
    void execute(IMessageHandler handler);
}