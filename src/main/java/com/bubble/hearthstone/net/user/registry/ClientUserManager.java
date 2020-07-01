package com.bubble.hearthstone.net.user.registry;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.DeleteUserEvent;
import com.bubble.hearthstone.net.event.events.IUserEvent;
// import com.bubble.hearthstone.net.event.events.LogoutEvent;
import com.bubble.hearthstone.net.event.events.SignupEvent;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.net.user.UserSave;
import com.bubble.hearthstone.net.user.registry.requests.GetSaveRequest;
import com.bubble.hearthstone.net.user.registry.requests.LoginRequest;
import com.bubble.hearthstone.net.user.registry.users.Users;
import com.bubble.hearthstone.util.debug.GameError;
import com.bubble.hearthstone.util.log.EventLogger;
import com.bubble.hearthstone.util.log.IEventLogger;
import com.bubble.hearthstone.util.net.facade.Requests;
import com.bubble.hearthstone.util.net.facade.UserRequests;
import com.bubble.hearthstone.util.net.module.ClientToken;
import com.bubble.hearthstone.util.net.module.INetwork;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.net.module.requests.UserAuthenticationRequest;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class ClientUserManager implements IUserManager {

    private final IEventLogger logger;
    private final INetwork network;
    private final IUserManager server;
    private User current;
    private UserSave save;

    public ClientUserManager(INetwork network) {
        logger = new EventLogger(ServiceLocator.getLogger(), this);
        this.network = network;
        server = null;
        loginToGuest();
    }

    private void loginToGuest() {
        login(Users.GUEST);
        logger.success("logged in as guest");
        // open login menu
        // ServiceLocator.getNetworkService().push(new ChangeMenuEvent(MenuType.LOGIN));
    }

    private void login(User user) {
        current = user;
        if (!user.equals(Users.GUEST)) {
            save = loadSave();
            //TODO: fix load bug
        }
        ServiceLocator.getNetworkService().login(user);
    }

    private UserSave loadSave() {
        return (UserSave) sendRequest(Requests.GET_SAVE);
    }

    private ClientToken getUserToken() {
        return (ClientToken) sendRequest(UserRequests.getClientToken);
    }

    @Override
    public boolean login(String username, String password) {
        final IResponse result = sendRequest(new LoginRequest(username, password));
        if (result.getData().equals(true)) { 
            login(new User(username, password));
            return true;
        }
         else {
            final GameError error = (GameError) result;
            // error.rai
        }
        return false;
    }

    @Override
    public boolean signup(String username, String password) {
        // network.sendRequest(new SignupEvent(username, password));
        return true;
    }

    @Override
    public boolean delete(String username, String password) {
        // network.sendRequest(new DeleteUserEvent(username, password));
        return true;
    }

    @Override
    public boolean logout(String username, String password) {
        // network.sendRequest(new LogoutEvent(username, password));
        return true;
    }

    public void handleEvent(IUserEvent event) {
        event.process(this);
    }

    @Override
    public void sendEvent(IGameEvent event) {
        // TODO Auto-generated method stub

    }

    private IResponse sendRequest(IRequest request) {
        return network.sendRequest(request);
    }

    // private boolean request(IRequest request) {
    //     return (Boolean) sendRequest(request).getData();
    // }

    @Override
    public boolean authenticate(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    public User getMe() {
        return current;
    }
}