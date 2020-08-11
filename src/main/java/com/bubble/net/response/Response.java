package com.bubble.net.response;

import com.google.gson.Gson;

public class Response {
    public final NetResponse type;
    public final String body;

    public Response(String json) {
        final Response response = new Gson().fromJson(json, Response.class);
        this.type = response.type;
        this.body = response.body;
    }

    public Response(boolean result) {
        this.type = result ? NetResponse.OK : NetResponse.ERROR;
        this.body = "";
    }

    public Response(NetResponse type, String body) {
        this.type = type;
        this.body = body;
    }

    public Response(NetResponse type, Object body) {
        this.type = type;
        this.body = new Gson().toJson(body);
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public static final Response OK = new Response(true);
    public static final Response ERROR = new Response(false);

}