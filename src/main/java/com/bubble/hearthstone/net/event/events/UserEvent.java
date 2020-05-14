package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.user.UserManager;

public abstract class UserEvent implements IGameEvent {
    
    public abstract void process(UserManager userManager);
}