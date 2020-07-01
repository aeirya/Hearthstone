package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;

public interface IRequestManager extends Runnable {
    IResponse handleRequest(IRequest request);
}
