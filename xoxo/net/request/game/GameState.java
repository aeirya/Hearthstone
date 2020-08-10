package xoxo.net.request.game;

import com.google.gson.Gson;

import xoxo.game.Player;

public class GameState {
    public final Player player;
    public final Player opponent;
    public final String winner;
    public final BoardState board;

    public GameState(Player me, Player opponent, String winner, BoardState board) {
        this.player = me;
        this.opponent = opponent;
        this.winner = winner;
        this.board = board;
    }

    public GameState(String string) {
        final GameState state = new Gson().fromJson(string, GameState.class);
        this.player = state.player;
        this.opponent = state.opponent;
        this.winner = state.winner;
        this.board = state.board;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public String getCurrentTurnPlayer() {
        return player.hasTurn() ? player.getSign().toString() : opponent.getSign().toString();
    }

    @Override
    public boolean equals(Object state) {
        if (! (state instanceof GameState)) return false;
        final GameState g = ((GameState) state);
        return g.player.getName().equals(player.getName())
         && g.board.toString().equals(board.toString())
         && ((g.winner == null && winner == null) || (g.winner != null && g.winner.equals(winner)));
    }

    @Override
    public int hashCode() {
        return player.getName().hashCode();
    }
}