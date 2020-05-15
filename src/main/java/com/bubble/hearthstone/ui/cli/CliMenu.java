package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.ui.Cli;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.IMenu;

public abstract class CliMenu implements IMenu {
    public abstract void printCommands();

    public void lunch(IGameGraphics graphics) {
        final Cli g = (Cli) graphics;
        g.load(this);
    }
}