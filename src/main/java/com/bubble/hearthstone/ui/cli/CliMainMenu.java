package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.ui.Cli;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.IMenu;

public class CliMainMenu implements IMenu {

    public void lunch(IGameGraphics graphics) {
        final Cli g = (Cli) graphics;
        g.message("Heeeey");
    }
    
}