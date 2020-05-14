package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.net.event.IGameEvent;

public class EventLogger {

    private final GameLogger logger;
    private final MyFileWriter writer;

    public EventLogger(GameLogger logger) {
        this.logger = logger;
        writer = new MyFileWriter("data/logs/game.log");
    }

    public void log(IGameEvent event) {
        final String message = event.getMessage();
        if (message != null) {
            logger.logEvent(message);
            writer.write(
                new EventLog(event).toString()
            );
        }
    }
    
    /*
    logging style:
    event timestamp event_description
    select 2020....20:22:20 card.mage 
    */
}