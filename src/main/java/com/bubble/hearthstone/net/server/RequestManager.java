package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.net.ClientManager;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;

public class RequestManager implements IRequestManager {
    private final IRequestHandler handler;
    private final ServerRequestReceiver receiver;
    private final ClientManager clients;

    public RequestManager(ClientManager clients) {
        this.clients = clients;
        handler = new RequestHandler();
        receiver = new ServerRequestReceiver();
    }

    public void run() {
        new Thread(
            () -> {
                while (true) {
                    final IRequest request = getNextRequest();
                    respond(request);
                }
            }
        ).start();
    }

    private void respond(IRequest request) {
        final IResponse response = handleRequest(request);
        final IClient client = findRequester(request);
        sendResponse(response, client);
    }

    private IRequest getNextRequest() {
        return receiver.get();
    }

    @Override
    public IResponse handleRequest(IRequest request) {
        return request.process(handler);
    }

    private IClient findRequester(IRequest request) {
        return clients.findClient(request.getToken());
    }

    private void sendResponse(IResponse response, IClient client) {
        client.getConnection().push(response);
    }
}
