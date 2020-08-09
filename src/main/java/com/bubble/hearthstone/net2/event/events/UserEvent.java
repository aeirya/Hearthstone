package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.user.UserManager;

@FunctionalInterface
public interface UserEvent {
    public abstract void process(UserManager userManager);
}