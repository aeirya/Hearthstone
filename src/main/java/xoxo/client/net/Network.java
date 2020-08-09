package xoxo.client.net;

import java.util.logging.Logger;

import com.google.gson.Gson;

import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;

public class Network {

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
        Logger.getLogger("client").info("connected");
        final Response response = server.getNext();
        if (response.type == NetResponse.OK) {
            auth = response.body;  
        }
    }

    public synchronized void request(Request request) {
        server.send(
            parse(request.sign(auth))
        );
    }

    public void request(NetRequest type, String body) {
        request(new Request(type, body));
    }

    public synchronized Response getResponse() {
        return server.getNext();
    }

    private String parse(Request request) {
        return new Gson().toJson(request);
    }
}