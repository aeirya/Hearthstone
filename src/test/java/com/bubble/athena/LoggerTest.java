// package com.bubble.athena;

// import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.assertTrue;

// import com.bubble.athena.server.GameServer;
// import com.bubble.athena.server.ServiceLocator;
// import com.bubble.util.log.ColoredGameLogger;

// import org.junit.Test;

// public class LoggerTest extends GameServer {
//     private boolean success;
//     public LoggerTest(int port) {
// 		super(port);
//     }
    
//     @Override
//     public void run() {
//         super.run();
//         ServiceLocator.getLogger().log("hi, how are you doing man!");
//         ServiceLocator.getLogger().error("hi, how are you doing man!", null);
//         success = true;
//         assertTrue(success);
//     }

//     @Test
//     void test() {
//         run();
//         assertNotNull(ServiceLocator.getLogger());
//     }

//     public static void main(String[] args) {
//         // LoggerTest test = new LoggerTest(8000);
//         // test.test();
//         new ColoredGameLogger().log("HI");
//         new ColoredGameLogger().info("HI");
//         new ColoredGameLogger().error("HI");
//     }
// }