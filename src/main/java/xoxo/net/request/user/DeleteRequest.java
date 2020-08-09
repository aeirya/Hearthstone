package xoxo.net.request.user;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;

public class DeleteRequest extends UserRequest {
    
    public DeleteRequest(String username, String password) {
        super(NetRequest.DELETE, new User(username, password));
    }

    public DeleteRequest(Request request) {
        super(request);
    }

    @Override
    public Response apply(IUserManager manager) {
        final User user = getUser();
        final String username = user.username;
        final String password = user.password;
        final boolean result = manager.delete(username, password);
        if (result) return new Response(username + " deleted");
        else return new Response(NetResponse.ERROR, "can't remove user: " + username);
    }
}