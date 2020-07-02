package com.bubble.hearthstone.module.event;

public interface IEventDispatcher {
    void dispatch(IEvent event);
}