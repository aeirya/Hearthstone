package xoxo.net.request.game;

import xoxo.game.Game;
import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;
import xoxo.server.user.OnlineUser;

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