package xoxo.net.request.user;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;

public class LoginRequest extends UserRequest {

    public LoginRequest(String username, String password) {
        super(NetRequest.LOGIN, new User(username, password));
    }

    public LoginRequest(String body) {
        super(NetRequest.LOGIN, body);
    }

    public LoginRequest(Request request) {
        super(request);
    }

    public Response apply(IUserManager manager) {
        final User user = getUser();
        final String username = user.username;
        final String password = user.password;
        final boolean result = manager.login(username, password);
        if (result) {
            manager.getOnlineUser(username).setAuth(getAuth());
            return new Response(NetResponse.OK, "hi " + username);
        } else {
            return new Response(NetResponse.ERROR, "can't sign you in");
        }
    }

}