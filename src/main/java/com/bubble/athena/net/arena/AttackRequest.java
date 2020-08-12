package com.bubble.athena.net.arena;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.arena.IArena;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;
import com.google.gson.Gson;

public class AttackRequest extends ArenaRequest {

    public AttackRequest(AttackEvent event) {
        super(NetRequest.ATTACK, event);
    }

    public AttackRequest(Request request) {
        super(request);
    }

    private AttackEvent getEvent() {
        return new Gson().fromJson(body, AttackEvent.class);
    }

    @Override
    public Response apply(IArena arena) {
        arena.handle(getEvent());
        return Response.OK;
    }
}