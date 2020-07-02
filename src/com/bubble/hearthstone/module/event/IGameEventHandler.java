package com.bubble.hearthstone.module.event;

public interface IGameEventHandler extends IEventHandler {
    void handleGraphicsEvent(IEvent event);
    void handleGameEvent(IEvent event);
    void register(IEventHandler handler, HandlerType type);
}