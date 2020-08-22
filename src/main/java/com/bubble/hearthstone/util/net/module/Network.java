package com.bubble.hearthstone.util.net.module;

import java.util.ArrayList;
import java.util.List;

public class Network implements INetwork {
    
    private final INetworkConnection connection;
    private final IReceiver receiver;
    private final List<ISender> senders;

    public Network() {
        connection = null;
        receiver = new Receiver(connection);
        senders = new ArrayList<>();
    }

    public void run() {
        new Thread(
            () -> {
                initiate();
                while(isAlive()) {
                    getResponse();
                }
            }
            ).start();
    }

    private void initiate() {
        receiver.run();
    }

    private boolean isAlive() {
        return connection.isAlive();
    }

    private void getResponse() {
        IResponse response = receiver.getNext();
        senders.removeIf(
            sender -> sender.checkResponse(response)
        );
    }

	@Override
	public IResponse sendRequest(IRequest request) {
        final ISender sender = addSender();
        return sender.send(request);
    }

    private ISender addSender() {
        final ISender sender = new Sender(connection);
        senders.add(sender);
        return sender;
    }
}

/* 

    request => 

    ==> (req)
    ==> server

    (#)
    reader (# =?)
    response.read()

*/