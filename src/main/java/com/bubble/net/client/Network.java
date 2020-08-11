package com.bubble.net.client;

import java.util.logging.Logger;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.net.client.service.INetworkService;
import com.bubble.net.client.service.NetworkService;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;

public class Network implements INetwork {

    private final INetworkService server;
    private String auth;
    
    public Network(String ip, int port) {
        server = initiateNetworkService(ip, port);
    }

    private INetworkService initiateNetworkService(String ip, int port) {
        return new NetworkService(ip, port);
    }

    public void connect() {
        server.connect();
        logConnected();
        getToken();
    }

    private void logConnected() {
        Logger.getLogger("client").info("connected");
    }

    private void getToken() {
        final Response response = getResponse();
        if (response.type == NetResponse.OK) {
            auth = response.body;
        }
    }

    public synchronized void request(Request request) {
        server.send(
            request.sign(auth).toString()
        );
        // later: add my parser here instead
    }

    // not should be here
    public void request(NetRequest type, String body) {
        request(new Request(type.toString(), body));
    }

    public synchronized Response getResponse() {
        return new Response(server.getNext());
    }
}