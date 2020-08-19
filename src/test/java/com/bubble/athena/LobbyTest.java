// package com.bubble.athena;

// import static org.junit.Assert.assertTrue;

// import com.bubble.athena.client.GameClient;
// import com.bubble.athena.client.net.ResponseWait;
// import com.bubble.athena.client.net.ServerAPI;
// import com.bubble.athena.net.chat.ChatMessage;
// import com.bubble.athena.net.test.TestCustomRequest;
// import com.bubble.athena.net.test.TestRequest;
// import com.bubble.athena.server.GameServer;
// import com.bubble.net.response.Response;

// import org.junit.Test;

// public class LobbyTest {
    
//     private boolean success = false;
//     @Test
//     public static void main(String[] args) {
//         LobbyTest test = new LobbyTest();
//         test.test1();
//         assertTrue(test.success);
//     }

//     LobbyTest() {
//         //
//     }

//     void test1() {
//         runServer();
//         ServerAPI api = api();
//         api.singup("a", "a");
//         api.login("a", "a");
//         api.findMatch();
//         api.sendRequest(new TestCustomRequest("aeirya", new ChatMessage("ai", "hassan")));
//         new ResponseWait(api, r -> System.out.println(r.toString())).start();
//         System.out.println("already passed");
//         api.sendRequest(new TestRequest(" my name is ah"));
//         Response res;
//         if ((res = api.getResponse()).isOK()) {
//             success = true;
//         }
//         else {
//             System.out.println(res);
//         }
//     }

//     GameServer runServer() {
//         GameServer server = new GameServer(8000);
//         server.run();
//         return server;
//     }

//     GameClient runClient() {
//         final GameClient client = new GameClient("localhost", 8000);
//         client.run();
//         return client;
//     }

//     ServerAPI api() {
//         return runClient().get();
//     }
// }