package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.ui.MenuType;

public class LogoutEvent implements IGameEvent {

    private final String message;

    public LogoutEvent(String... args) {
        message = setMessage(args);
    }

    @Override
    public void process(GameManager manager) {
        manager.launch(MenuType.LOGIN);
        manager.logout();
    }
    
    private String setMessage(String... args) {
        if (args.length > 0) 
            return "User [" + args[0] + "] logged out of the game";
        else return null;
    }

    @Override
    public String getMessage() {
        return message;
    }
}