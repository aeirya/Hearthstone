package com.bubble.athena.net.request;

import com.bubble.athena.server.IServerHandler;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class GameRequest extends Request implements IGameRequest {
    
    private GameRequest(NetRequest type, String body) {
        super(type.toString(), body);
    }

    public GameRequest(NetRequest type) {
        this(type, "");
    }

    public GameRequest(Request request) {
        super(request);
    }

    public NetRequest getType() {
        return NetRequest.valueOf(type);
    }

    public Response apply(IServerHandler server) {
        return new Response(NetResponse.ERROR, "request with unknown type");
    }

    /**
     * DEVELOPER NOTES:
     * there are two ways to decode this,
     * either remake this by calling the SOMEREQUEST(String json) using reflection (and passing the getJson() to it)
     * or using the SOMEREQUEST(REQUEST request)
     * 
     * keeping  both to prevent bugs
     */
}