package xoxo.net.request.menu;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.request.user.IUserManager;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;
import xoxo.server.score.Scoreboard;
import xoxo.server.user.OnlineUser;

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