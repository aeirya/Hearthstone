// package com.bubble.hearthstone.net.event.events;

// import com.bubble.hearthstone.net.server.IGameServer;
// import com.bubble.hearthstone.net.user.registry.IUserManager;
// import com.bubble.hearthstone.ui.MenuType;

// public class LoginRequest extends UserEvent {

//     private String message;
//     private boolean result;

//     public LoginRequest(String username, String password) {
//         super(username, password);
//     }

//     public void process(IGameServer server) {
//         super.process(server);
//         if (result) server.repond()
//     }

//     public void process(IUserManager userManager) { 
//         result = userManager.login(username, password);
//         message = setMessage(result);
//     }
    
//     private String setMessage(boolean isSuccessful) {
//         String msg = "User [" + username + "] ";
//         if (isSuccessful) msg += "logged in successfully";
//         else msg += "failed to log in ";
//         return msg;
//     }
    
//     @Override
//     public String getMessage() {
//         return message;
//     }
// }