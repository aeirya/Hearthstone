package com.bubble.athena.net.arena;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.arena.IArena;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class GetArenaRequest extends ArenaRequest {

    public GetArenaRequest(NetRequest type) {
        super(NetRequest.GET_ARENA);
    }

    @Override
    public Response apply(IArena arena) {
        // return new Response(
        //     NetResponse.OK, 
        //     arena
        // )
        return null;
    }
    
}