package com.bubble.hearthstone.util.net.module.requests;

import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.util.net.module.ClientToken;
import com.bubble.hearthstone.util.net.module.IRequestHandler;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.Request;
import com.bubble.hearthstone.util.net.module.Response;

public class GetShopRequest extends Request {

    public IResponse process(IRequestHandler server) {
        final Shop shop = server.getShop();
        return Response.holdData(shop).setID(id);
    }

    @Override
    public void addToken(ClientToken token) {
        // TODO Auto-generated method stub

    }

    @Override
    public ClientToken getToken() {
        // TODO Auto-generated method stub
        return null;
    }
}

