package xoxo.net.request.menu;

import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.request.NetRequest;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

import xoxo.net.request.Request;
import xoxo.net.request.user.IUserManager;
import xoxo.server.score.Scoreboard;

public class GetScoreboardRequest extends Request {

    public GetScoreboardRequest(Request request) {
        super(request);
    }
    
    public GetScoreboardRequest() {
        super(NetRequest.GET_SCOREBOARD);
    }

    public Response apply(OnlineUser user, Scoreboard scoreboard, IUserManager usermanager) {
        return new Response(
            NetResponse.OK,
            scoreboard.getState(user, usermanager)
        );
    }
}