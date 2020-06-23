package com.bubble.hearthstone.util.net.module;

import com.bubble.hearthstone.net.server.IRequestHandler;

public interface IRequestAction {
    IResponse process(IRequestHandler handler);
}