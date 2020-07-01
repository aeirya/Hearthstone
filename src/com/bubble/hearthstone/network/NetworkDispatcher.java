// package com.bubble.hearthstone.network;

// import java.io.OutputStream;
// import java.io.PrintWriter;
// import java.net.Socket;

// import com.bubble.hearthstone.client.service.event.IEvent;
// import com.bubble.hearthstone.client.service.event.IEventDispatcher;

// public class NetworkDispatcher implements IEventDispatcher {

//     private final Socket socket;
//     private final OutputStream out;
//     private final PrintWriter pw;
    
//     NetworkDispatcher(Socket socket) {
//         this.socket = socket;
//         out = socket.getOutputStream();
//         pw = new PrintWriter(out);
        
//     }

//     @Override
//     public void dispatch(IEvent event) {
        
//     }
    
// }