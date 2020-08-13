package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.net.ServerAPI;

import org.junit.Test;

public class FriendshipTest extends NetworkTest {
    
    public static void main(String[] args) {
        new FriendshipTest();
    }

    FriendshipTest() {
        runServer();
        fastLogin(api(), "a");
        ServerAPI api = fastLogin(api(), "b");
        test1(api);
    }

    @Test
    void test1(ServerAPI api) {
        api.sendFriendRequest("a");
        assertTrue(true);
    }

}