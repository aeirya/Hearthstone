package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.net.user.UserManager;

public class EventLogger implements IEventLogger {

    private final GameLogger logger;
    private final MyFileWriter writer;
    private final UserManager userManager;

    public EventLogger(GameLogger logger, UserManager userManager) {
        this.logger = logger;
        this.userManager = userManager;
        writer = new MyFileWriter();
    }

    private String getWritePath(User user) {
        return "data/logs/user-" + user.getUsername() + ".log";
    }

    public void log(IGameEvent event) {
        final String message = event.getMessage();
        if (message != null) {
            logger.logEvent(message);
            writeToLogFile(event, getWritePath(userManager.getUser()));
            writeToLogFile(event, getWritePath(UserManager.GLOBAL));
        }
    }
    
    private void writeToLogFile(IGameEvent event, String path) {
        writer
                .setPath(path)
                .write(
                    new EventLog(event).toString()
            );
    }

    // maybe i just should use the service locator logger instead of these

    public void error(String error) {
        logger.warning(error);
    }

    public void success(String message) {
        logger.info(message);
    }

    //TODO: implement the user change scenario
    
    /*
    logging style:
    event timestamp event_description
    select 2020....20:22:20 card.mage 
    */
}