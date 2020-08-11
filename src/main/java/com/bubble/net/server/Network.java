package com.bubble.net.server;

import java.net.Socket;

import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.request.Request;
import com.bubble.net.response.NetResponse;
import com.bubble.net.response.Response;
import com.bubble.net.server.accept.IClientAcceptor;
import com.bubble.net.server.accept.NetworkListener;
import com.bubble.net.server.client.Client;
import com.bubble.net.server.client.ClientManager;
import com.bubble.net.server.client.IClientRequestHandler;

public class Network implements INetwork, IClientRequestHandler, IClientAcceptor {

    private final ClientManager clients;
    private final NetworkListener listener;
    private final IRequestHandler handler;

    public Network(int port, IRequestHandler handler) {
        clients = new ClientManager();
        listener = new NetworkListener(this, port);
        this.handler = handler;
    }

    // accepting clients
    public void start() {
        listener.listen();
    }

    public void accept(Socket socket) {
        accept(new Client(socket, this));
    }

    private void accept(Client client) {
        clients.add(client);
        System.out.println("client accepted");
        sendToken(client);
    }

    private void sendToken(Client client) {
        final Response response = new Response(NetResponse.OK, client.getAuth());
        client.send(response.toString());
    }

    public void bye(Client client) {
        clients.bye(client);
    }
    //

    // handling input data
    @Override
    public void request(Client client, String data) {
        final Request request = new Request(data);
        if (authenticate(client, request)) {
            handler.handle(request);
        }
    }

    private boolean authenticate(Client client, Request request) {
        return client.getAuth().equals(request.getAuth());
    }

    public void respond(String response, String auth) {
        clients.find(auth).send(response);
    }

    // refactor this out
    @Override
    public void respond(Response response, OnlineUser user) {
        respond(response.toString(), user.getAuth());
    }
}