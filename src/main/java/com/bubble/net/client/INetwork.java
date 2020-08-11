package com.bubble.net.client;

import com.bubble.athena.client.net.IResponseCatcher;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;

public interface INetwork extends IResponseCatcher {
    void connect();
    void request(Request request);
    void request(NetRequest type, String body);
    Response getResponse();
    
}