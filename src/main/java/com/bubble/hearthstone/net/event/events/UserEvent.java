package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.user.UserManager;

public interface UserEvent extends IGameEvent {
    public abstract void process(UserManager userManager);
}