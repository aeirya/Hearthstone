package com.bubble.athena;

import com.bubble.athena.client.net.ServerAPI;
import com.bubble.athena.net.chat.ChatMessage;
import com.bubble.athena.net.test.TestCustomRequest;

public class CustomRequestTest extends NetworkTest {
    public static void main(String[] args) {
        new CustomRequestTest();
    }

    public CustomRequestTest() {
        runServer();
        fastLogin(api(), "a");
        ServerAPI api = fastLogin(api(), "b");
        System.out.println(
        api.request(new TestCustomRequest("aeirya", new ChatMessage("ali", "salam")))
        );
    }
}