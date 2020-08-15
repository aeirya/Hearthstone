package com.bubble.net.request;

import com.google.gson.Gson;

public class Request {
    public final String type;
    public final String body;
    private final String json;
    private String authToken;

    protected Request(Request request) {
        this.body = request.body;
        this.authToken = request.authToken;
        this.type = request.type;
        this.json = request.json;
    }
    
    public Request(String json) {
        final Request r = new Gson().fromJson(json, Request.class);
        this.type = r.type;
        this.body = r.body;
        this.authToken = r.authToken;
        this.json = json;
    }

    public Request(String type, String body) {
        this.type = type;
        this.body = body;
        this.authToken = "";
        this.json = this.toString();
    }

    public Request sign(String auth) {
        this.authToken = auth;
        return this;
    }

    public String getAuth() {
        return authToken;
    }

    public String getJson() {
        return json;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}