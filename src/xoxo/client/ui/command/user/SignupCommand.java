package xoxo.client.ui.command.user;

import com.bubble.athena.client.net.ServerAPI;

public class SignupCommand extends UserCommand {
    public SignupCommand() {
        super("register");
    }

    @Override
    public void act(ServerAPI api) {
        api.singup(username, password);
    }
}