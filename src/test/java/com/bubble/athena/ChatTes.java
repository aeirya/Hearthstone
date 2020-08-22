package com.bubble.athena;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.bubble.athena.client.net.ServerAPI;

import org.gradle.internal.impldep.org.junit.Test;
import org.junit.Ignore;

@Ignore
public class ChatTes extends NetworkTes {

    @Test
    public void serverShouldPrintChatHistory() {
        fail("HI!");
        assertNotNull(userChat);
    }

    private String globalChat;
    private String userChat;

    public ChatTes() {
        ServerAPI send = fastLogin(api(), "a");
        ServerAPI rec = fastLogin(api(), "b");
        test1(send, rec);
        test2(send, rec);
        test3(send, rec);
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
        globalChat = send.getGlobalChat().toString();
    }

    void test3(ServerAPI send, ServerAPI rec) {
        userChat = send.getUserChat().toString();
    }

    public static void main(String[] args) {
        // new ChatTest
    }
}