package xoxo.client.ui.menu;

import java.io.PrintWriter;

import com.bubble.athena.client.net.ServerAPI;

import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.game.BackToMainMenuCommand;
import xoxo.client.ui.command.replay.BackCommand;
import xoxo.client.ui.command.replay.IReplayer;
import xoxo.client.ui.command.replay.NextCommand;
import xoxo.game.Save;
import xoxo.net.request.game.BoardState;

public class ReplayMenu extends Menu implements IReplayer {

    private final Save save;
    private int turn = 0;

    public ReplayMenu(ServerAPI api, IMenuLauncher launcher) {
        super(api);
        save = api.getReplay();
        addCommand(new NextCommand(this));
        addCommand(new BackCommand(this));
        addCommand(new BackToMainMenuCommand(launcher));
    }
    
    @Override
    public void print(PrintWriter out) {
        out.println(table(getBoard()));
        out.flush();
    }

    private BoardState getBoard() {
        return save.getBoard(turn).getState();
    }

    private String table(BoardState board) {
        return new GameMenu.TableCreator().makeTable(board);
    }

    public void next() {
        if (turn + 1 > save.getSize()) return;
        turn += 1;
    }

    public void back() {
        turn -= 1;
        if (turn < 0) turn = 0;
    }
}