
package xoxo.client.ui.menu;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.jakewharton.fliptables.FlipTableConverters;

import xoxo.client.net.ServerAPI;
import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.mainmenu.FindGameCommand;
import xoxo.client.ui.command.mainmenu.LogoutCommand;
import xoxo.net.request.menu.ScoreRow;
import xoxo.net.request.menu.ScorebaordState;
import xoxo.server.score.Entry;

public class MainMenu extends Menu {

    private ScorebaordState scoreboard;

    public MainMenu(IMenuLauncher lnchr, ServerAPI api) {
        super(api);
        addCommand(new FindGameCommand(lnchr));
        addCommand(new LogoutCommand(lnchr));
    }
    
    @Override
    protected void update() {
        ScorebaordState update = api.getScoreboard();
        if(scoreboard != null && 
        scoreboard.toString().equals(update.toString())) return;
        this.scoreboard = update;
        isNeedsRefresh = true;
    }

    @Override
    public void print(PrintWriter out) {
        if (scoreboard == null) return;
        new ScoreboardPrinter(scoreboard, out);
    }

    private class ScoreboardPrinter {
        ScoreboardPrinter(ScorebaordState state, PrintWriter out) {
            out.println(getMyStatusTable(state));
            out.println();
            final List<ScoreRow> rows = new ArrayList<>();
            rows.addAll(state.getOnline());
            rows.addAll(state.getOffline());
            out.println(FlipTableConverters.fromIterable(rows, ScoreRow.class));
            out.flush();
        }

        String getMyStatusTable(ScorebaordState state) {
            String[] header = {"user", "wins", "lost" };
            final Entry me = state.getMe();
            String[][] data = { { me.getUser(), String.valueOf(me.getWins()), String.valueOf(me.getLosts()) } };
            return FlipTableConverters.fromObjects(header, data);
        }

        
    }
}