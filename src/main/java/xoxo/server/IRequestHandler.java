package xoxo.server;

import xoxo.net.request.Request;

public interface IRequestHandler {
    void handle(Request request);
}
