package com.bubble.hearthstone.module.event;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private final IMessageHandler logic;
    private final List<IMessageReceiver> receivers;

    public EventBus() {
        logic = null;
        receivers = new ArrayList<>();
    }

    public void receive(IMessage message, IMessageSender sender) {
        if (sender.equals(logic)) broadcast(message);
        // else sendToLogic(message);
    }

    private void broadcast(IMessage message) {
        receivers.forEach(r -> r.receive(message));
    }

    // private void sendToLogic(IMessage message) {
    //     logic.receive(message);
    // }
}