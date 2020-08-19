// package com.bubble.athena;

// import static org.junit.Assert.assertNotNull;

// import com.bubble.athena.client.GameClient;
// import com.bubble.athena.client.net.ServerAPI;
// import com.bubble.athena.server.GameServer;

// import org.gradle.internal.impldep.org.junit.Ignore;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

// @Ignore
// public class NetworkTest {

//     protected GameServer server;
//     private GameClient client1;
//     protected ServerAPI api1;

//     @Test
//     public void serverShouldRun() {
//         server = runServer();
//         assertNotNull(server);
//     }

//     @Before
//     public void startServer() {
//         server = runServer();
//     }

//     @After
//     public void closeServer() {
//         server.stop();
//         client1.quit();
//     }

//     public GameServer runServer() {
//         GameServer server = new GameServer(8000);
//         server.run();
//         sleep(10);
//         return server;
//     }

//     void sleep(int time) {
//         try {
//             Thread.sleep(time);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }

//     GameClient runClient() {
//         final GameClient client = new GameClient("localhost", 8000);
//         client.run();
//         return client;
//     }

//     ServerAPI api() {
//         return runClient().get();
//     }

//     ServerAPI fastLogin(ServerAPI api, String str) {
//         api.login(str, str);
//         return api;
//     }
// }