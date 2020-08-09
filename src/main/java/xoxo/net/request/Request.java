package xoxo.net.request;

import com.google.gson.Gson;

public class Request {
    private String authToken;
    public final NetRequest type;
    public final String body;

    public Request(NetRequest type) {
        this.type = type;
        this.body = "";
    }

    public Request(NetRequest type, String body) {
        this.type = type;
        this.body = body;
    }

    public Request(NetRequest type, Object body) {
        this.type = type;
        this.body = new Gson().toJson(body);
    }

    protected Request(Request request) {
        this.body = request.body;
        this.authToken = request.authToken;
        this.type = request.type;
    }

    public Request sign(String auth) {
        this.authToken = auth;
        return this;
    }

    public String getAuth() {
        return authToken;
    }
}