package com.bubble.athena.server;

import com.bubble.athena.server.user.UserManager;
import com.bubble.net.request.Request;
import com.bubble.net.server.INetwork;
import com.bubble.net.server.IRequestHandler;
import com.bubble.net.server.Network;

public class GameServer implements IRequestHandler {

    private final INetwork net;
    private final IRequestHandler core;
    private final ServiceLocator services;

    public GameServer(int port) {
        services = initiateServices();
        net = new Network(port, this);
        core = new RequestHandler(net, services);
    }

    private ServiceLocator initiateServices() {
        final ServiceLocator ser = new ServiceLocator();
        final UserManager usermanager = new UserManager();
        ser.provideUserManager(usermanager);
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
