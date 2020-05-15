package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.input.EnumCommands;

public class CliLoginMenu extends CliMenu {

    public CliLoginMenu() {
        this.menuCommands = new CliLoginMenuCommnads();
    }

    private final class CliLoginMenuCommnads extends MenuCommands {
        CliLoginMenuCommnads() {
            super();
            mapper.put("login", EnumCommands.LOGIN);
            mapper.put("reg" ,EnumCommands.SIGNUP);
            mapper.put("del", EnumCommands.DELETE_USER);
            mapper.put("ls", EnumCommands.LIST);
            mapper.put("help", EnumCommands.HELP);
            mapper.put("quit", EnumCommands.QUIT);
        }
    }
}