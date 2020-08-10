package com.bubble.athena.server.request;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.net.user.LoginRequest;
import com.bubble.athena.net.user.SignupRequest;
import com.bubble.net.request.Request;

public class RequestMapper {
    private final Map<NetRequest, Class<? extends GameRequest>> map;

    public RequestMapper() {
        map = new EnumMap<>(NetRequest.class);
        map.put(NetRequest.LOGIN, LoginRequest.class);
        map.put(NetRequest.REGISTER, SignupRequest.class);
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