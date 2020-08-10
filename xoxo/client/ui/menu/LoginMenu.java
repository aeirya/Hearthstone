package xoxo.client.ui.menu;

import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.user.LoginCommand;
import xoxo.client.ui.command.user.SignupCommand;

public class LoginMenu extends Menu {

    public LoginMenu(IMenuLauncher launcher) {
        super(null);
        addCommand(new LoginCommand(launcher));
        addCommand(new SignupCommand());
    }
}