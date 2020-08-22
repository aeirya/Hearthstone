package xoxo.client.ui.command.replay;

import com.bubble.athena.client.net.ServerAPI;

import xoxo.client.ui.menu.ReplayMenu;

public class NextCommand extends ReplayCommand {

    public NextCommand(ReplayMenu menu) {
        super("next", menu);
    }

    @Override
    public void act(ServerAPI api) {
        menu.next();
    }    
}