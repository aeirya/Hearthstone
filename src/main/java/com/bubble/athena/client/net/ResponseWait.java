package com.bubble.athena.client.net;

import java.util.function.Consumer;
import com.bubble.net.response.Response;

public class ResponseWait {
    private final Thread thread;
    private boolean started = false;
    private Object lock = new Object();

    public ResponseWait(IResponseCatcher net, Consumer<Response> action, String name) {
        thread = new Thread(
            () -> {
                started = true;
                synchronized(lock) {
                    lock.notifyAll();
                }
                final Response r = net.getResponse();
                action.accept(r);
            }
            , name);
    }

    public ResponseWait(IResponseCatcher net, Consumer<Response> action) {
        this(net, action, "ResponseWait");
    }

    public void start() {
        thread.start();
        sleep();
    }
    
    private void sleep() {
        synchronized(lock) {
            try {
                while(!started) {
                    lock.wait();
                }
            } catch(Exception e) {
                //
            }
        } 
    }
}