package com.bubble.hearthstone.net;

import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.event.DummyNetworkEventQueue;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.INetworkEventQueue;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class NetworkService implements INetworkService {
    
    private final Shop shop; // the shop located at the "server"
    private final INetworkEventQueue queue;
    private User me;

    /** dummy network service */
    public NetworkService(ResourceManager resourceManager) {
        // we could even save the resource manager maybe
        this.shop = new Shop(resourceManager);
        this.queue = new DummyNetworkEventQueue();
    }

    public Shop getShop() {
        return shop;
    }


    public User getMe() {
        return me;
    }

    public void login(User user) {
        me = user;
    }

    @Override
    public INetworkService connect() {
        //we can set the queue now..
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