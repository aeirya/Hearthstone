package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.input.ICommand;
import com.bubble.hearthstone.ui.Cli;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.IMenu;
import java.util.Map;

public abstract class CliMenu implements IMenu {
    
    protected MenuCommands menuCommands;
    private Cli graphics;

    public void launch(IGameGraphics graphics) {
        final Cli g = (Cli) graphics;
        g.load(this);
        this.graphics = g;
        printCommands();
    }

    public void printCommands() {
        graphics.message(
            menuCommands.getCommands()
        );
    }
    
    public Map<String, ICommand> getMapper() { 
        return menuCommands.mapper;
    }
}