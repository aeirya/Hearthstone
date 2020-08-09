
package xoxo.client.ui.command.replay;

import xoxo.client.net.ServerAPI;

public class BackCommand extends ReplayCommand {

    public BackCommand(IReplayer menu) {
        super("back", menu);
    }

    @Override
    public void act(ServerAPI api) {
        menu.back();
    }
}