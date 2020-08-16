package com.bubble.athena;

import static org.junit.Assert.assertTrue;

import com.bubble.athena.client.net.ServerAPI;

import org.junit.Test;

public class ChatTest extends NetworkTest {
    
    @Test
    public static void main(String[] args) {
        final ChatTest test = new ChatTest();
        assertTrue(test.success);
    }

    ChatTest() {
        runServer();
        ServerAPI send = fastLogin(api(), "a");
        ServerAPI rec = fastLogin(api(), "b");
        test1(send, rec);
        test2(send, rec);
        test3(send, rec);
        
        success = true;
    }

    void test1(ServerAPI send, ServerAPI rec) {
        send.sendMessage("b", "hi");
        send.sendMessage("b", "answer me");
        send.sendMessage("hi");
        send.sendMessage("hmmm");
        // System.out.println(
        //     rec.getResponse().toString()
        // );
    }

    void test2(ServerAPI send, ServerAPI rec) {
        System.out.println(
            send.getGlobalChat().toString()
        );
    }

    void test3(ServerAPI send, ServerAPI rec) {
        System.out.println(
            send.getUserChat()
        );
    }
}