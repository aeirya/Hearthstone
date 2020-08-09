package xoxo.server.net;

import com.google.gson.Gson;

import xoxo.net.connection.NetworkListener;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;
import xoxo.server.IRequestHandler;

public class Network implements INetwork {

    private final ClientManager clients;
    private final NetworkListener listener;
    private final IRequestHandler handler;

    public Network(int port, IRequestHandler handler) {
        clients = new ClientManager();
        listener = new NetworkListener(this, port);
        this.handler = handler;
    }

    public void accept(Client client) {
        clients.add(client);
        System.out.println("client accepted");
        sendToken(client);
    }

    public void sendToken(Client client) {
        final Response response = new Response(NetResponse.OK, client.getAuth());
        client.send(response.getBytes());
    }

    @Override
    public void start() {
        listener.listen();
    }

    @Override
    public void request(Client client, byte[] data) {
        final String json = decode(data);
        final Request request = toRequest(json);
        if (authenticate(client, request.getAuth())) {
            handler.handle(request);
        }
    }

    private String decode(byte[] data) {
        return new String(data);
    }

    private Request toRequest(String json) {
        return new Gson().fromJson(json, Request.class);
    }

    private boolean authenticate(Client client, String auth) {
        return client.getAuth().equals(auth);
    }

    public void respond(String response, String auth) {
        clients.find(auth).send(response.getBytes());
    }
}