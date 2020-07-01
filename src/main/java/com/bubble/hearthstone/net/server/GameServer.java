package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.controller.GameSession;
import com.bubble.hearthstone.interfaces.Updatable;
import com.bubble.hearthstone.net.ClientManager;
import com.bubble.hearthstone.net.INetworkService;
import com.bubble.hearthstone.net.event.EventHandler;
import com.bubble.hearthstone.net.event.GameEventHandler;
import com.bubble.hearthstone.net.event.IGameEvent;
// import com.bubble.hearthstone.net.event.events.BroadcastMessageEvent;
import com.bubble.hearthstone.net.event.events.IUserEvent;
import com.bubble.hearthstone.net.event.events.arena.IArenaEvent;
import com.bubble.hearthstone.net.user.registry.ServerUserManager;
import com.bubble.hearthstone.util.net.module.ClientToken;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.time.Waiter;

public class GameServer implements IGameServer, Updatable {
    private final ServerUserManager userManager;
    private final EventHandler eventHandler;
    private final INetworkService network;
    private GameSession currentSession;
    private final ClientManager clientManager;

    private final RequestManager requestManager;

    public GameServer() {
        this.userManager = new ServerUserManager(this);
        this.eventHandler = new GameEventHandler(this, userManager).start();
        this.clientManager = new ClientManager();
        this.requestManager = new RequestManager(clientManager);
        this.network = null;
    }

    public void start() {
        requestManager.run();
    }

    public void handleUserEvent(IUserEvent event) {
        userManager.handleEvent(event);
    }

    public void handleArenaEvent(IArenaEvent event) {
        currentSession.handleArenaEvent(event);
    }

    public void broadcast(String message) {
        // network.push(
        // new BroadcastMessageEvent(message)
        // );
    }

    public void startGameSession() {
        currentSession = network.startGameSession();
    }

    public void update() {
        receiveEvents();
        // do render
        Waiter.sleep();
    }

    private void receiveEvents() {
        while (network.hasNext()) {
            final IGameEvent event = network.get();
            eventHandler.receive(event);
        }
    }

    @Override
    public void respond(IResponse response, ClientToken token) {
        // TODO Auto-generated method stub

    }
}