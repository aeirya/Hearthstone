// package com.bubble.hearthstone.util.log;

// import com.bubble.hearthstone.net.event.IGameEvent;

// import java.time.format.DateTimeFormatter;  
// import java.time.LocalDateTime;    

// public class EventLog { 

//     private final IGameEvent event;
//     private final String time;

//     public EventLog(IGameEvent event) {
//         this.event = event;
//         this.time = Time.getNow();
//     }

//     public String toString() {
//         return event.getMessage() + " @ " + time;
//     }

//     private static class Time {   
//         static String getNow() {
//             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//             LocalDateTime now = LocalDateTime.now();  
//             return dtf.format(now);
//         }
//     }
// }