package com.bubble.hearthstone.net.event.events.arena;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.events.ChangeMenuEvent;
import com.bubble.hearthstone.ui.MenuType;

public class LunchArenaEvent extends ChangeMenuEvent {
    
    public LunchArenaEvent() {
        super(MenuType.ARENA);
    }

    @Override
    public void process(GameManager manager) {
        manager.startGameSession();
        super.process(manager);
    }
}