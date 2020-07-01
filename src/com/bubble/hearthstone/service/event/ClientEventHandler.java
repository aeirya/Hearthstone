package com.bubble.hearthstone.service.event;

import java.util.EnumMap;

public class ClientEventHandler implements IClientEventHandler {

    private final EnumMap<HandlerType, IEventHandler> handlers;

    public ClientEventHandler() {
        handlers = new EnumMap<>(HandlerType.class);
    }

	@Override
	public void handle(IEvent event) {
		event.process(this);
    }

    @Override
    public void handleGraphicsEvent(IEvent event) {
        get(HandlerType.GRAPHICS).handle(event);
    }

    @Override
    public void handleNetworkEvent(IEvent event) {
       get(HandlerType.NETWORK).handle(event);
    }
    
    private IEventHandler get(HandlerType type) {
        return handlers.get(type);
    }

    public void register(IEventHandler handler, HandlerType type) {
        handlers.put(type, handler);
    }
}