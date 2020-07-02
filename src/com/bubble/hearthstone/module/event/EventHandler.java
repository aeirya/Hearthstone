package com.bubble.hearthstone.module.event;

import java.util.EnumMap;

public class EventHandler implements IGameEventHandler {

    private final EnumMap<HandlerType, IEventHandler> handlers;

    public EventHandler() {
        handlers = new EnumMap<>(HandlerType.class);
    }

	@Override
	public void handle(IEvent event) {
		event.process(this);
    }

    @Override
    public void handleGraphicsEvent(IEvent event) {
        get(H   andlerType.GRAPHICS).handle(event);
    }

    @Override
    public void handleGameEvent(IEvent event) {
        get(HandlerType.LOGIC).handle(event);
    }

    private IEventHandler get(HandlerType type) {
        return handlers.get(type);
    }

    public void register(IEventHandler handler, HandlerType type) {
        handlers.put(type, handler);
    }
}