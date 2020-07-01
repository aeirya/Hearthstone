package com.bubble.hearthstone.service.event;

public interface IEventDispatcher {
    void dispatch(IEvent event);
}