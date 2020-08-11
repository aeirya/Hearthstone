package com.bubble.net.request;

import com.google.gson.Gson;

public class Request {
    public final String type;
    public final String body;
    private String authToken;

    protected Request(Request request) {
        this.body = request.body;
        this.authToken = request.authToken;
        this.type = request.type;
    }
    
    public Request(String json) {
        final Request r = new Gson().fromJson(json, Request.class);
        this.type = r.type;
        this.body = r.body;
        this.authToken = r.authToken;
    }

    public Request(String type, String body) {
        this.type = type;
        this.body = body;
        this.authToken = "";
    }

    public Request sign(String auth) {
        this.authToken = auth;
        return this;
    }

    public String getAuth() {
        return authToken;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}