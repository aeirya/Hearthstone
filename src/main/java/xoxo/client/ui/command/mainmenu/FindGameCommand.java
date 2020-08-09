package xoxo.client.ui.command.mainmenu;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.net.ServerAPI;
import xoxo.client.ui.ICommand;
import xoxo.client.ui.command.Command;
import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.MenuType;
import xoxo.net.response.NetResponse;

public class FindGameCommand extends Command {

    private final IMenuLauncher launcher;

    public FindGameCommand(IMenuLauncher launcher) {
        super("start playing");
        this.launcher = launcher;
    }

    @Override
    public ICommand takeArgs(Scanner in, PrintWriter out) {
        return this;
    }

    @Override
    public void act(ServerAPI api) {
        api.findMatch();
        System.out.println("looking for game");
        if(api.getResponse().type == NetResponse.OK) {
            System.out.println("game found");
            launcher.launch(MenuType.GAME);
        }
    }
    
}