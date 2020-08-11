package com.bubble.athena.client.net;

import com.bubble.athena.net.lobby.FindMatchRequest;
import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.user.DeleteRequest;
import com.bubble.athena.net.user.LoginRequest;
import com.bubble.athena.net.user.LogoutRequest;
import com.bubble.athena.net.user.SignupRequest;
import com.bubble.net.client.Network;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class ServerAPI implements IResponseCatcher {
    private final Network net;
    private String username;
    private String password; // this could be removed
    
    public ServerAPI(Network net) {
        this.net = net;
    }

    private void log(Response response) {
        System.out.println(response.body);
    }

    private void log() {
        System.out.println(
            net.getResponse()
        );
    }

    private void dump() {
        Response r = net.getResponse();
        if(!r.isOK()) {
            System.out.println(r.toString());
        }
    }

    public void login(String username, String password) {
        net.request(new LoginRequest(username, password));
        final Response response = net.getResponse();
        if (response.type == NetResponse.OK) {
            this.username = username;
            this.password = password;
        }
        log(response);
    }

    public void logout() {
        net.request(new LogoutRequest(username, password));
        dump();
    }

    public void singup(String username, String password) {
        net.request(new SignupRequest(username, password));
        dump();
    }

    public void removeUser(String username, String password) {
        net.request(new DeleteRequest(username, password));
        dump();
    }

    public void findMatch() {
        net.request(new FindMatchRequest(username));
        dump();
    }

    public synchronized Response getResponse() {
        return net.getResponse();
    }

    // public GameState getUpdate() {
    //     net.request(new GetUpdateRequest());
    //     final Response response = getResponse();
    //     if (response.type.equals(NetResponse.OK)) {
    //         return new GameState(response.body);
    //     } else {
    //         return null;
    //     }
    // }

    public String getUsername() {
        return username;
    }

    // public ScorebaordState getScoreboard() {
    //     net.request(new GetScoreboardRequest());
    //     final Response r = getResponse();
    //     return new ScorebaordState(r.body);
    // }

    // public void finishMatch() {
    //     net.request(new MatchFinishedRequest());
    //     dump();
    // }

    // public Save getReplay() {
    //     net.request(new GetSaveRequest());
    //     final Response r = getResponse();
    //     if(r.body != null) {
    //         return new Save(r.body);
    //     } else return null;
    // }
}