package xoxo.server;

import xoxo.net.request.Request;
import xoxo.net.request.user.IUserManager;
import xoxo.net.response.OkResponse;
import xoxo.net.response.Response;
import xoxo.server.net.INetwork;
// import xoxo.server.score.Scoreboard;
// import xoxo.server.user.OnlineUser;
// import xoxo.server.user.UserManager;

public class RequestHandler implements IRequestHandler {

    // private final IUserManager usermanager;
    // private final MatchFinder matcher;
    private final INetwork net;
    // private final Scoreboard scoreboard;

    public RequestHandler(INetwork net) {
        this.net = net;
        // usermanager = new UsesrManager();
        // scoreboard = new Scoreboard();
        // matcher = new MatchFinder(usermanager, net);
    }

    public synchronized void handle(Request request) {
        respond(apply(request), request.getAuth());
    }

    public Response apply(Request request) {
        switch(request.type) {
            default:
            return new OkResponse();
        }
    }

    public synchronized void respond(Response response, String auth) {
        net.respond(response.toString(), auth);
    }

    // public OnlineUser getUser(Request request) { 
    //     return usermanager
    //         .findUserWithAuth(request.getAuth());
    // }
}