package com.bubble.hearthstone.module.logic.user;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.service.ServiceLocator;
import com.bubble.hearthstone.module.service.ServiceManager;
import com.bubble.hearthstone.net.user.User;

public class UserManager implements IUserManager {

    public UserManager(ServiceLocator services) {
        // services.get
    }

    public UserManager(ServiceManager services) {
        //
    }

    @Override
    public boolean login(String username, String password) {
        // 
        return false;
    }

    @Override
    public boolean signup(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean logout(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean authenticate(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User getMe() {
        // TODO Auto-generated method stub
        return null;
    }

    public void sendEvent(IEvent event) {
        EventSystem.dispatch(event);
    }
}