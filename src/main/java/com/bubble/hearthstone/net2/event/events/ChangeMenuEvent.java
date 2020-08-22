package com.bubble.hearthstone.net2.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.ui.MenuType;

public class ChangeMenuEvent implements IClientEvent {

    protected final MenuType menu;

    public ChangeMenuEvent(MenuType menu) {
        this.menu = menu;
    }

    @Override
    public void process(GameManager manager) {
        manager.getGraphics().launch(menu);
    }
    
}