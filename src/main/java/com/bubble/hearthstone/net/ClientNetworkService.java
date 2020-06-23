package com.bubble.hearthstone.net;

import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.util.net.facade.Requests;
import com.bubble.hearthstone.util.net.module.INetwork;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;

public class ClientNetworkService {

    private final INetwork network;

    public ClientNetworkService() {
        network = null;
    }

    private IResponse request(IRequest request) {
        return network.sendRequest(request);
    }

    public Shop getShop() {
        return (Shop) request(Requests.GET_SHOP);
    }
}

// TODO: make server request handler
