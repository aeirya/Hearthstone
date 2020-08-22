
package xoxo.client.ui.command.game;

import java.io.PrintWriter;
import java.util.Scanner;

import com.bubble.athena.client.net.ServerAPI;

import xoxo.client.ui.ICommand;
import xoxo.client.ui.command.Command;
import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.MenuType;

public class ReplayCommand extends Command {

    private final IMenuLauncher lnchr;

    public ReplayCommand(IMenuLauncher lnchr) {
        super("replay game");
        this.lnchr = lnchr;
    }

    @Override
    public ICommand takeArgs(Scanner in, PrintWriter out) {
        return this;
    }

    @Override
    public void act(ServerAPI api) {
        lnchr.launch(MenuType.REPLAY);
    }
    
}