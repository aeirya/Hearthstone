package com.bubble.hearthstone.client.service.event;

public interface IEventDispatcher {
    void dispatch(IEvent event);
}