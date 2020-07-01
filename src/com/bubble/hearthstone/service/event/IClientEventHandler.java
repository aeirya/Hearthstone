package com.bubble.hearthstone.service.event;

public interface IClientEventHandler extends IEventHandler {
    void handleGraphicsEvent(IEvent event);
    void handleNetworkEvent(IEvent event);
    void register(IEventHandler handler, HandlerType type);
}