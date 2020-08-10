// package com.bubble.net.server;

// import com.bubble.net.request.Request;
// import com.bubble.net.response.Response;
// import com.bubble.net.server.client.IClientRequestHandler;
// import com.bubble.net.server.client.IClientResponseHandler;

// import xoxo.net.request.user.IUserManager;
// import xoxo.net.response.OkResponse;


// // TODO: refactor this outside of this packaging

// public class RequestHandler implements IRequestHandler {

//     // private final IUserManager usermanager;
//     // private final MatchFinder matcher;
//     private final INetwork net;
//     // private final Scoreboard scoreboard;

//     public RequestHandler(INetwork net) {
//         this.net = net;
//         // usermanager = new UsesrManager();
//         // scoreboard = new Scoreboard();
//         // matcher = new MatchFinder(usermanager, net);
//     }

//     public synchronized void handle(Request request) {
//         respond(apply(request), request.getAuth());
//     }

//     public Response apply(Request request) {
//         switch(request.type) {
//             default:
//             return new OkResponse();
//         }
//     }

//     public synchronized void respond(Response response, String auth) {
//         net.respond(response.toString(), auth);
//     }

//     // public OnlineUser getUser(Request request) { 
//     //     return usermanager
//     //         .findUserWithAuth(request.getAuth());
//     // }
// }