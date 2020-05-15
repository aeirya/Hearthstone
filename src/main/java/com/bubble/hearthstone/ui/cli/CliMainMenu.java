package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.input.EnumCommands;

public class CliMainMenu extends CliMenu {

    public CliMainMenu() {
        this.menuCommands = new CliMainMenuCommnads();
    }

    private final class CliMainMenuCommnads extends MenuCommands {
        CliMainMenuCommnads() {
            super();
            mapper.put("out", EnumCommands.LOGOUT);
            mapper.put("store", EnumCommands.SHOP);
            mapper.put("help", EnumCommands.HELP);
            mapper.put("quit", EnumCommands.QUIT);
        }
    }
}