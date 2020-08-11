package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.net.ServerAPI;

import org.junit.Test;

public class ChatTest extends NetworkTest {
    
    @Test
    public static void main(String[] args) {
        assertTrue(new ChatTest().success);
    }

    ChatTest() {
        runServer();
        ServerAPI send = fastLogin(api(), "a");
        ServerAPI rec = fastLogin(api(), "b");
        send.sendMessage("b", "hi");
        System.out.println(
            rec.getResponse().toString()
        );
        success = true;
    }
}