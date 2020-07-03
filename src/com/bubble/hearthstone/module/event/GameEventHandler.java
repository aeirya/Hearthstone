package com.bubble.hearthstone.module.event;

import java.util.EnumMap;

public class GameEventHandler implements IGameEventHandler {

    private final EnumMap<HandlerType, IEventHandler> handlers;

    public GameEventHandler() {
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
    public void handleGameEvent(IEvent event) {
        get(HandlerType.LOGIC).handle(event);
    }

    @Override
    public void handleUserEvent(IEvent event) {
        get(HandlerType.USER).handle(event);
    }

    private IEventHandler get(HandlerType type) {
        return handlers.get(type);
    }

    public void register(HandlerType type, IEventHandler handler) {
        handlers.put(type, handler);
    }
}