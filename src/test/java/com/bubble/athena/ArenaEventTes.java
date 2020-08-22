package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.net.ServerAPI;


public class ArenaEventTes extends NetworkTes {
    
    public static void main(String[] args) {
        new ArenaEventTes().attack();
    }

    void attack() {
        runServer();
        fastLogin(api(), "a").findMatch();
        ServerAPI api = fastLogin(api(), "b");
        api.findMatch();
        sleep(1000);
        api.attack();
    }
}