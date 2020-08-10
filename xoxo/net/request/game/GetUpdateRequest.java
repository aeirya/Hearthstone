package xoxo.net.request.game;

import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.request.NetRequest;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

import xoxo.game.Game;
import xoxo.net.request.Request;

public class GetUpdateRequest extends Request {

    public GetUpdateRequest(Request request) {
        super(request);
    }

	public GetUpdateRequest() {
        super(NetRequest.GET_UPDATE);
    }
    
    public Response apply(OnlineUser user) {
        final Game game = user.getMatch();
        if (game != null /* && game.isToBeUpdated() */) {
            GameState state = game.getState(user.getPlayer());
            return new Response(NetResponse.OK, state.toString());
        } else {
            return new Response(NetResponse.ERROR, "");
        }
    }
}