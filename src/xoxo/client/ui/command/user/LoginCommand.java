package xoxo.client.ui.command.user;

import com.bubble.athena.client.net.ServerAPI;

import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.MenuType;

public class LoginCommand extends UserCommand {

    private final IMenuLauncher launcher;

    public LoginCommand(IMenuLauncher launcher) {
        super("login");
        this.launcher = launcher;
    }

    @Override
    public void act(ServerAPI api) {
        api.login(username, password);
        launcher.launch(MenuType.MAIN);
    }
}