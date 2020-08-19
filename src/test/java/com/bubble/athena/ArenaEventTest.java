// package com.bubble.athena;

// import static org.junit.Assert.assertTrue;

// import com.bubble.athena.client.net.ServerAPI;


// public class ArenaEventTest extends NetworkTest {
    
//     public static void main(String[] args) {
//         new ArenaEventTest().attack();
//     }

//     void attack() {
//         runServer();
//         fastLogin(api(), "a").findMatch();
//         ServerAPI api = fastLogin(api(), "b");
//         api.findMatch();
//         sleep(1000);
//         api.attack();
//         success = true;
//         assertTrue("yay", success);
//     }
// }