package com.bubble.athena.client.net;

import com.bubble.athena.net.lobby.FindMatchRequest;

import java.util.List;

import com.bubble.athena.net.chat.ChatMessage;
import com.bubble.athena.net.chat.ChatRequest;
import com.bubble.athena.net.chat.GetChatHistoryRequest;
import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.user.DeleteRequest;
import com.bubble.athena.net.user.LoginRequest;
import com.bubble.athena.net.user.LogoutRequest;
import com.bubble.athena.net.user.SignupRequest;
import com.bubble.athena.server.ServiceLocator;
import com.bubble.net.client.Network;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;
import com.bubble.util.log.ColoredGameLogger;
import com.bubble.util.log.IGameLogger;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class ServerAPI implements IResponseCatcher {
    private final Network net;
    private String username;
    private String password; // this could be removed
    private IGameLogger logger;

    public ServerAPI(Network net) {
        this.net = net;
        logger = new ColoredGameLogger();
    }

    private void log(Response response) {
        logger.log(response.body);
    }

    public void log() {
        log(
            net.getResponse()
        );
    }

    private void dump() {
        Response r = net.getResponse();
        if(!r.isOK()) {
            logger.warning(r.toString());
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

    public void sendMessage(String to, String msg) {
        net.request(new ChatRequest(new ChatMessage(username, to, msg)));
        dump();
    }

    public void sendMessage(String msg) {
        net.request(new ChatRequest(new ChatMessage(username, msg)));
        dump();
    }

    public List<String> getGlobalChat() {
        net.request(new GetChatHistoryRequest());
        final Response r = getResponse();
        return new Gson().fromJson(r.body, List.class);
    }

    public List<String> getUserChat() {
        net.request(new GetChatHistoryRequest(username));
        final Gson gson = new Gson();
        return gson.fromJson(getResponse().body, new TypeToken<List<String>>(){}.getType());
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