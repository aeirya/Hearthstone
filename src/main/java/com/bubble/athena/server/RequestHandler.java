package com.bubble.athena.server;

import com.bubble.athena.net.lobby.ILobbyRequest;
import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.IGameRequest;
import com.bubble.athena.net.user.IUserRequest;
import com.bubble.athena.server.request.RequestMapper;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;
import com.bubble.net.server.INetwork;
import com.bubble.net.server.IRequestHandler;

public class RequestHandler implements IRequestHandler, IServerHandler {

    private final INetwork net;
    private final ServiceLocator services;
    private final RequestMapper mapper;

    public RequestHandler(INetwork net, ServiceLocator services) {
        mapper = new RequestMapper();
        this.net = net;
        this.services = services;
    }

    public synchronized void handle(Request request) {
        System.out.println("handling request of type: " + request.type);
        respond(apply(convert(request)), request.getAuth());
    }

    private Response apply(GameRequest request) {
        return mapper.get(request).apply(this);
    }
        
    private GameRequest convert(Request request) {
        return mapper.get(new GameRequest(request));
    }

    public Response handleUserRequest(GameRequest request) {
        return getUserRequest(request).apply(services.getUserManager());
    }

    private IUserRequest getUserRequest(GameRequest request) {
        return (IUserRequest) request;
    }

    public Response handleLobbyRequest(IGameRequest request) {
        return getLobbyRequest(request).apply(services.getLobby());
    }

    private ILobbyRequest getLobbyRequest(IGameRequest request) {
        return (ILobbyRequest) request;
    }

    public synchronized void respond(Response response, String auth) {
        net.respond(response.toString(), auth);
    }
}