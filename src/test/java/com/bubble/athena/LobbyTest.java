package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.GameClient;
import com.bubble.athena.client.net.ResponseWait;
import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;
import com.bubble.net.response.Response;

import org.junit.Test;

public class LobbyTest {
    
    private boolean success = false;
    @Test
    public static void main(String[] args) {
        LobbyTest test = new LobbyTest();
        assertTrue(test.success);
    }

    LobbyTest() {
        runServer();
        ServerAPI api = api();
        api.singup("a", "a");
        api.login("a", "a");
        api.findMatch();
        Response res;
        new ResponseWait(api, r -> System.out.println(r.toString())).start();
        if ((res = api.getResponse()) == Response.OK) {
            success = true;
        }
        else {
            System.out.println(res);
        }
    }

    GameServer runServer() {
        GameServer server = new GameServer(8000);
        server.run();
        return server;
    }

    GameClient runClient() {
        final GameClient client = new GameClient("localhost", 8000);
        client.run();
        return client;
    }

    ServerAPI api() {
        return runClient().get();
    }
}