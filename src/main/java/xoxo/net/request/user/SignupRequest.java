package xoxo.net.request.user;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;

public class SignupRequest extends UserRequest {

    public SignupRequest(String username, String password) {
        super(NetRequest.REGISTER, new User(username, password));
    }

    public SignupRequest(Request request) {
        super(request);
    }

    @Override
    public Response apply(IUserManager manager) {
        final User user = getUser();
        final String username = user.username;
        final String password = user.password;
        final boolean result = manager.signup(username, password);
        if (result) return new Response(username + " signed up successfully");
        else return new Response(NetResponse.ERROR, "can't resgister user: " + username);
    }
    
}