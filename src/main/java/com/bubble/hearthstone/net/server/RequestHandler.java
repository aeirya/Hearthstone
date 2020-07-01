package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.INetworkService;
import com.bubble.hearthstone.net.user.registry.requests.UserRequest;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.IUserRequest;

public class RequestHandler implements IRequestHandler {
    private final INetworkService networkService;

    public RequestHandler() {
        networkService = null;
    }

    public Shop getShop() {
        return networkService.getShop();
    }

    public Arena getArena() {
        return networkService.getArena();
    }

    @Override
    public IResponse handleRequest(IRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IResponse handleUserRequest(IUserRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IResponse handleUserRequest(UserRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
}