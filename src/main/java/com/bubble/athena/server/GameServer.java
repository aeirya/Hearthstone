package com.bubble.athena.server;

import com.bubble.athena.server.lobby.Lobby;
import com.bubble.athena.server.user.UserManager;
import com.bubble.net.request.Request;
import com.bubble.net.server.INetwork;
import com.bubble.net.server.IRequestHandler;
import com.bubble.net.server.Network;
import com.bubble.util.log.ColoredGameLogger;
import com.bubble.util.log.IGameLogger;
import com.bubble.util.resource.DummyResourceManager;

public class GameServer implements IRequestHandler {

    private final INetwork net;
    private final IRequestHandler core;
    private final ServiceLocator services;

    public GameServer(int port) {
        net = new Network(port, this);
        services = initiateServices();
        core = new RequestHandler(net, services);
    }

    private ServiceLocator initiateServices() {
        final IGameLogger logger = new ColoredGameLogger();
        ServiceLocator.getInstance().provideLogger(logger).provideResources(new DummyResourceManager());
        final ServiceLocator ser = new ServiceLocator();
        final UserManager usermanager = new UserManager();
        ser.provideUserManager(usermanager);
        final Lobby lobby = new Lobby(usermanager, net);
        ser.provideLobby(lobby);
        return ser;
    }

    public void run() {
        net.start();
    }

    @Override
    public void handle(Request request) {
        core.handle(request);
    }
}
