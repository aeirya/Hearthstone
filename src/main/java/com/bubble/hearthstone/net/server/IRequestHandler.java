package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.user.registry.requests.UserRequest;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.IUserRequest;

public interface IRequestHandler {
    Shop getShop();
    Arena getArena();
    IResponse handleRequest(IRequest request);
    IResponse handleUserRequest(IUserRequest request);
    IResponse handleUserRequest(UserRequest request);
}