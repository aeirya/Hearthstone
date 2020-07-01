package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GuiManager;
import com.bubble.hearthstone.net.client.GameClient;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.util.services.ModuleLocator;

public class ChangeMenuEvent implements IGuiEvent {

    protected final MenuType menu;

    public ChangeMenuEvent(MenuType menu) {
        this.menu = menu;
    }

    @Override
    public void process(GameClient client) {
        ModuleLocator.getGraphics().launch(menu);
    }

    @Override
    public void process(GuiManager gui) {
        gui.launch(menu);
    }
}