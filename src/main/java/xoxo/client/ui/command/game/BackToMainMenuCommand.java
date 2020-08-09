package xoxo.client.ui.command.game;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.net.ServerAPI;
import xoxo.client.ui.ICommand;
import xoxo.client.ui.command.Command;
import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.MenuType;

public class BackToMainMenuCommand extends Command {

    private final IMenuLauncher lnchr;

    public BackToMainMenuCommand(IMenuLauncher lnchr) {
        super("quit");
        this.lnchr = lnchr;
    }

    @Override
    public void act(ServerAPI api) {
        lnchr.launch(MenuType.MAIN);
        api.finishMatch();
    }

    @Override
    public ICommand takeArgs(Scanner in, PrintWriter out) {
        return this;
    }
    
}