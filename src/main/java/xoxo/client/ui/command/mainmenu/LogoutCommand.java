
package xoxo.client.ui.command.mainmenu;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.net.ServerAPI;
import xoxo.client.ui.ICommand;
import xoxo.client.ui.command.Command;
import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.MenuType;

public class LogoutCommand extends Command {

    private final IMenuLauncher launcher;

    public LogoutCommand(IMenuLauncher launcher) {
        super("logout");
        this.launcher = launcher;
    }

    @Override
    public ICommand takeArgs(Scanner in, PrintWriter out) {
        return this;
    }

    @Override
    public void act(ServerAPI api) {
        launcher.launch(MenuType.LOGIN);
        api.logout();
    }
}