package xoxo.net.request.menu;

import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.request.NetRequest;
import com.bubble.net.response.Response;

import xoxo.game.Game;
import xoxo.net.request.Request;
import xoxo.net.response.OkResponse;
import xoxo.server.score.MatchResult;
import xoxo.server.score.Scoreboard;

public class MatchFinishedRequest extends Request {

	public MatchFinishedRequest() {
		super(NetRequest.MATCH_FINISH);
    }
    
    public MatchFinishedRequest(Request request) {
        super(request);
    }

    public Response apply(OnlineUser user, Scoreboard scoreboard) {
        apply(user.getUsername(), user.getMatch().getOpponent(user.getPlayer()).getName(), scoreboard, user.getMatch());
        user.setInMatch(false);
        return new OkResponse();
    }

    private void apply(String user, String opponent, Scoreboard scoreboard, Game state) {
        if (state.hasWon(user) || ! state.isFinished()) {
            scoreboard.addRecord(user, getResult(user, state));
            scoreboard.addRecord(opponent, getResult(opponent, state));
        }
    }

    private MatchResult getResult(String user, Game game) {
        if ( !game.isFinished()) {
            return MatchResult.DRAW;
        } else if (game.hasWon(user)) {
            return MatchResult.WIN;
        } else {
            return MatchResult.LOST;
        }
    }
}