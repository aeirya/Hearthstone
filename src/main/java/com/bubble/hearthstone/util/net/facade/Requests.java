package com.bubble.hearthstone.util.net.facade;

import com.bubble.hearthstone.net.user.registry.requests.GetSaveRequest;
import com.bubble.hearthstone.util.net.module.Request;
import com.bubble.hearthstone.util.net.module.requests.GetShopRequest;

public class Requests {

    private Requests() { }
    // public static final Request GET_PLAYER;
    public static final Request GET_SHOP = new GetShopRequest();
    public static final Request GET_SAVE = new GetSaveRequest();
    public static final Request LAUNCH_ARENA = null;
    

    // public static final Request GET_ARENA = new GetArenaRequest();
}