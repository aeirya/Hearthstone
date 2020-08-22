package com.bubble.hearthstone.net2.event.events;

import com.bubble.hearthstone.net2.user.UserManager;

@FunctionalInterface
public interface UserEvent {
    public abstract void process(UserManager userManager);
}