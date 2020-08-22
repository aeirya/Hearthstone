package com.bubble.hearthstone.net2;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.controller.GameSession;
import com.bubble.hearthstone.controller.GameSession.GameMode;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net2.event.DummyNetworkEventQueue;
import com.bubble.hearthstone.net2.event.IGameEvent;
import com.bubble.hearthstone.net2.event.INetworkEventQueue;
import com.bubble.hearthstone.net2.user.User;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class NetworkService implements INetworkService {

    private final INetworkEventQueue queue;
    private final Shop shop; // the shop located at the "server"
    private GameSession session; //session running at the "server"

    private User me;

    /** dummy network service */
    public NetworkService(ResourceManager resourceManager) {
        // we could even save the resource manager maybe
        this.shop = new Shop(resourceManager);
        this.queue = new DummyNetworkEventQueue();
    }

    public GameSession startGameSession() {
        // moved from game manager, needs to change
        if (session == null)
            session = new GameSession(getMe(), GameMode.OFFLINE);
        else {
            // a session is already running
        }
        return session;
    }

    public Shop getShop() {
        return shop;
    }

    public Arena getArena() {
        return session.getArena();
    }

    public User getMe() {
        return me;
    }

    public void login(User user) {
        me = user;
    }

    @Override
    public INetworkService connect() {
        // we can set the queue now..
        return this;
    }

    @Override
    public IGameEvent get() {
        return queue.get();
    }

    @Override
    public void push(IGameEvent event) {
        queue.push(event);
    }

    // note: network service and resource manager should
    // be distinguishable or they'll be merged

    // note 2: i guess this is useless for now ...
}