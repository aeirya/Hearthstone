package com.bubble.hearthstone.util.net.facade;

import com.bubble.hearthstone.util.net.module.Request;
import com.bubble.hearthstone.util.net.module.requests.GetShopRequest;

public class Requests {

    private Requests() { }
    // public static final Request GET_PLAYER;
    public static final Request GET_SHOP = new GetShopRequest();
    // public static final Request GET_ARENA = new GetArenaRequest();
}