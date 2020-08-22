package com.bubble.athena.net.arena;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.arena.IArena;
import com.bubble.net.response.Response;

public class AttackRequest extends ArenaRequest {

    private AttackEvent event;
    
    public AttackRequest(AttackEvent event) {
        super(NetRequest.ATTACK);
        this.event = event;
    }

    @Override
    public Response apply(IArena arena) {
        arena.handle(event);
        return Response.OK;
    }
}