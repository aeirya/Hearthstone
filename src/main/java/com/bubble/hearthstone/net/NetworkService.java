package com.bubble.hearthstone.net;

import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class NetworkService implements INetworkService {
    private Shop shop; //the shop located at the "server"
    
    /** dummy network service */
    public NetworkService(ResourceManager resourceManager) {
        //we could even save the resource manager maybe
        this.shop = new Shop(resourceManager);
        this.connect();
    }
    
    //connects to the server or whatever
    public void connect() {
       //nothing yet :p
    }

    public Shop getShop() {
        return shop;
    }

    private User me;

    public User getMe() {
        return me;
    }

    public void login(User user) {
        me = user;
    }

    // note: network service and resource manager should
    // be distinguishable or they'll be merged

    // note 2: i guess this is useless for now ...
}