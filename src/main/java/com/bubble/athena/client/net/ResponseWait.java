package com.bubble.athena.client.net;

import java.util.function.Consumer;
import com.bubble.net.client.INetwork;
import com.bubble.net.response.Response;

public class ResponseWait {
    private final Thread thread;

    public ResponseWait(INetwork net, Consumer<Response> action, String name) {
        thread = new Thread(
            () -> {
                final Response r = net.getResponse();
                action.accept(r);
            }
            , name);
    }

    public ResponseWait(INetwork net, Consumer<Response> action) {
        this(net, action, null);
    }

    public void start() {
        thread.start();
    }
}