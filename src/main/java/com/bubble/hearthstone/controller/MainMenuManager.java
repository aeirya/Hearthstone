package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.interfaces.IInterpreter;
import com.bubble.hearthstone.net2.INetworkService;
import com.bubble.hearthstone.net2.event.IGameEvent;
import com.bubble.hearthstone.net2.event.events.BroadcastMessageEvent;
import com.bubble.hearthstone.net2.event.events.ChangeMenuEvent;
import com.bubble.hearthstone.net2.event.events.LogoutEvent;
import com.bubble.hearthstone.net2.event.events.arena.LunchArenaEvent;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.util.services.ServiceLocator;

import java.util.Map;

public class MainMenuManager implements IInterpreter {

    public void interpret(String event) {
        map.get(event).run();
    }

    private INetworkService getNetworkService() {
        return ServiceLocator.getNetworkService();
    }

    private void sendEvent(IGameEvent event) {
        getNetworkService().push(event);
    }

    private final
        Map <String, Runnable> map =
            Map.of(
                "Start",
                () -> sendEvent(new LunchArenaEvent())
                ,
                "See Decks",
                () -> sendEvent(new ChangeMenuEvent(MenuType.DECKS))
                ,
                "Profile",
                () -> {}
                ,            
                "Settings",
                () -> sendEvent(new ChangeMenuEvent(MenuType.SETTINGS))
                ,
                "Logout",
                () -> sendEvent(new LogoutEvent())
                ,            
                "Quit",
                () -> sendEvent(new BroadcastMessageEvent("quit.."))
        );
}