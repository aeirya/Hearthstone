package xoxo.net.request.user;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;

public class LogoutRequest extends UserRequest {
    
    public LogoutRequest(String username, String password) {
        super(NetRequest.LOGOUT, username, password);
    }

    public LogoutRequest(Request request) {
        super(request);
    }

    @Override
    public Response apply(IUserManager manager) {
        final User user = getUser();
        final String username = user.username;
        final String password = user.password;
        final boolean result = manager.logout(username, password);
        if (result) return new Response(username + " logged out");
        else return new Response(NetResponse.ERROR, "no such online user");
    }
}
