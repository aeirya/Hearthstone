package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.user.User;

public class EventLogger {

    private final GameLogger logger;
    private final MyFileWriter writer;

    public EventLogger(GameLogger logger, User user) {
        this.logger = logger;
        writer = new MyFileWriter("data/logs/user-" + user.getUsername() + ".log");
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

    //TODO: implement the user change scenario
    
    /*
    logging style:
    event timestamp event_description
    select 2020....20:22:20 card.mage 
    */
}