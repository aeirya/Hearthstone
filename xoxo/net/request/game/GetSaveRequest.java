package xoxo.net.request.game;

import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.request.NetRequest;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

import xoxo.net.request.Request;

public class GetSaveRequest extends Request {
    public GetSaveRequest() {
        super(NetRequest.REPLAY);
    }

    public Response apply(OnlineUser me) {
        return new Response(NetResponse.OK, me.getMatch().getSave());
    }
}