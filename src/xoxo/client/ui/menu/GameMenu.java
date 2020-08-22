package xoxo.client.ui.menu;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.stream.IntStream;

import com.bubble.athena.client.net.ServerAPI;
import com.jakewharton.fliptables.FlipTableConverters;

import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.game.BackToMainMenuCommand;
import xoxo.client.ui.command.game.PlayCommand;
import xoxo.client.ui.command.game.ReplayCommand;
import xoxo.game.Block;
import xoxo.game.Player;
import xoxo.game.Sign;
import xoxo.net.request.game.BoardState;
import xoxo.net.request.game.GameState;

public class GameMenu extends Menu {
    private GameState state;
    private final IMenuLauncher launcher;

    public GameMenu(ServerAPI api, IMenuLauncher launcher) {
        super(api);
        addCommand(new PlayCommand());
        addCommand(new BackToMainMenuCommand(launcher));
        this.launcher = launcher;
    }

    @Override
    protected void update() {
        final GameState update = api.getUpdate();
        if (update != null) {
            if (update.equals(state)) return;
            state = update;
            isNeedsRefresh = true;
            if (update.winner != null) {
                endGame();
            }
        }
    }

    private void endGame() {
        api.finishMatch();
        isAlive = false;
        addCommand(new ReplayCommand(launcher));
    }

    @Override
    public void print(PrintWriter out) {
        if (state == null) return;
        printStatus(out);
        out.println(table(state.board));
        out.flush();
    }

    private String table(BoardState state) {
        return new TableCreator().makeTable(state);
    }
    
    private void printStatus(PrintWriter out) {
        out.println(getPlayerStatus());
        out.flush();
    }

    private String getPlayerStatus() {
        String[] headers = { state.player.getSign().toString(), state.opponent.getSign().toString() };
        if(state.winner == null) {
            String[][] data = { 
                { state.player.getName(), state.opponent.getName() } ,
                { turn(state.player), turn(state.opponent) }
            };
            return FlipTableConverters.fromObjects(headers, data);
        } else {
            String[][] data = { 
                { state.player.getName(), state.opponent.getName() } ,
                { winner(state.player), winner(state.opponent) }
            };
            return FlipTableConverters.fromObjects(headers, data);
        }
    }

    private String turn(Player player) {
        return player.hasTurn() ? "turn" : "-";
    }

    private String winner(Player player) {
        return player.getName().equals(state.winner) ? "winner!" : "-";
    }

    public static class TableCreator {
        public String makeTable(BoardState board) {
            return table(board);
        }

        private String table(BoardState board) {
            final Iterator<Block> blocks = board.getBlocks().iterator();
            final int N = board.getSize();
            return FlipTableConverters.fromObjects(tableHead(N), tableBody(N, blocks));
        }
    
        private String[] tableHead(int n) {
            return IntStream.range(-1, n).mapToObj(String::valueOf).toArray(String[]::new);
        }
    
        private String[][] tableBody(int n, Iterator<Block> blocks) {
            final String[][] table = new String[n][n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    table[i][j+ 1] = signToStr(blocks.next().getSign());
                }
            }
            for (int i = 0; i < n; i++) {
                table[i][0] = String.valueOf(i);
            }
            return table;
        }
    
        private String signToStr(Sign sgn) {
            if (sgn == null) return "";
            else return sgn.toString();
        }
    } 
}