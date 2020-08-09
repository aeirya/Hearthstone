package xoxo.net.request.game;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;
import xoxo.server.user.OnlineUser;

public class GetSaveRequest extends Request {
    public GetSaveRequest() {
        super(NetRequest.REPLAY);
    }

    public Response apply(OnlineUser me) {
        return new Response(NetResponse.OK, me.getMatch().getSave());
    }
}