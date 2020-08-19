package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.GameClient;
import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.server.GameServer;
import com.bubble.net.response.NetResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NetworkTestCaseTest {

    private GameServer server;

    private GameClient client;
    private ServerAPI api;

    private GameClient client2;
    private ServerAPI api2;

    @Before
    public void before() {
        server = runServer();
        client = runClient();
    }

    GameServer runServer() {
        GameServer server = new GameServer(8000);
        server.run();
        sleep(10);
        return server;
    }

    void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        client.quit();
        server.stop();
    }

    GameClient runClient() {
        final GameClient client = new GameClient("localhost", 8000);
        client.run();
        return client;
    }

    ServerAPI fastLogin(ServerAPI api, String str) {
        api.login(str, str);
        return api;
    }

    ServerAPI fastLogin(GameClient client, String str) {
        return fastLogin(client.get(), str);
    }

    @Test
    public void firstClientShouldLogin() {
        api = fastLogin(client, "a");
        assertNotNull(api.getUser());
    }

    @Test
    public void secondClientShouldStartAndLogin() {
        client2 = runClient();
        api2 = fastLogin(client2, "b");
        assertNotNull(api2.getUser());
    }

    @Test
    public void matchShouldStart() {
        firstClientShouldLogin();
        secondClientShouldStartAndLogin();
        api.findMatch();
        api2.findMatch();
        assertEquals(NetResponse.OK, api.getResponse().type);
    }

    @Test
    public void playerShouldAttack() {
        matchShouldStart();
        api.attack();
        
    }
}