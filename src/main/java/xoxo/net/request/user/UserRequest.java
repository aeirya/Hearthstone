package xoxo.net.request.user;

import com.google.gson.Gson;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.Response;

public abstract class UserRequest extends Request {

    protected UserRequest(NetRequest type, String username, String password) {
        super(type, new User(username, password));
    }

    public UserRequest(NetRequest type, User user) {
        super(type, user);
    }

    public UserRequest(NetRequest type, String body) {
        super(type, body);
    }

    protected UserRequest(Request request) {
        super(request);
    }

    public User getUser() {
        return new Gson().fromJson(body, User.class);
    }

    public abstract Response apply(IUserManager manager);
}