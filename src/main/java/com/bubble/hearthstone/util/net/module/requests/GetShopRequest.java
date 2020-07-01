package com.bubble.hearthstone.util.net.module.requests;

import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.server.IRequestHandler;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.Request;
import com.bubble.hearthstone.util.net.module.Response;

public class GetShopRequest extends Request {

    public IResponse process(IRequestHandler server) {
        final Shop shop = server.getShop();
        return Response.holdData(shop).setID(id);
    }
}

