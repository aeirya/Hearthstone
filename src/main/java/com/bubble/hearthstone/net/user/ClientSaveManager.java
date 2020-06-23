package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.util.net.facade.Requests;
import com.bubble.hearthstone.util.net.module.INetwork;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IRequestSender;
import com.bubble.hearthstone.util.net.module.IResponse;

public class ClientSaveManager implements IRequestSender {
    private final INetwork network;

    public ClientSaveManager() {
        network = null;
    }

    public UserSave loadSave() {
        return (UserSave) request(Requests.GET_SAVE);
    }

    @Override
    public IResponse request(IRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
}