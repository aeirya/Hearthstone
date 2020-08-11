package com.bubble.athena.server.request;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

import com.bubble.athena.net.lobby.ChatRequest;
import com.bubble.athena.net.lobby.FindMatchRequest;
import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.net.user.DeleteRequest;
import com.bubble.athena.net.user.LoginRequest;
import com.bubble.athena.net.user.LogoutRequest;
import com.bubble.athena.net.user.SignupRequest;
import com.bubble.net.request.Request;

public class RequestMapper {
    private final Map<NetRequest, Class<? extends GameRequest>> map;

    public RequestMapper() {
        map = new EnumMap<>(NetRequest.class);
        // user requests
        map.put(NetRequest.LOGIN, LoginRequest.class);
        map.put(NetRequest.REGISTER, SignupRequest.class);
        map.put(NetRequest.DELETE, DeleteRequest.class);
        map.put(NetRequest.LOGOUT, LogoutRequest.class);
        // lobby requests
        map.put(NetRequest.FIND_MATCH, FindMatchRequest.class);
        map.put(NetRequest.CHAT_MESSAGE, ChatRequest.class);
    }

    public GameRequest get(GameRequest request) {
        try {
            return map.get(request.getType()).getDeclaredConstructor(Request.class).newInstance(request);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            return request;
        }
    }
}