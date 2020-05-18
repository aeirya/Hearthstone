package com.bubble.hearthstone.controller.event;

import com.bubble.hearthstone.net.event.IGameEvent;

//this is mainly a note for me 

public enum GameEvent {
    //user
    SIGN_UP,
    SIGN_IN,
    DELETE,
    
    //menu
    START,
    QUIT, 
    LIST,
    NAVIGATE,

    //shop
    BUY,
    SELL,

    //deck
    ADD,
    REMOVE,

    //hero
    SELECT


    //every command
    //and also "error" events
    //time stamp: exact time
}