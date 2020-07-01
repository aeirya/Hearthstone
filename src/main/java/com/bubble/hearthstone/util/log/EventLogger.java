package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.net.user.registry.ClientUserManager;
import com.bubble.hearthstone.net.user.registry.IUserManager;
import com.bubble.hearthstone.net.user.registry.users.Users;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class EventLogger implements IEventLogger {

    private final GameLogger logger;
    private final MyFileWriter writer;
    private final IUserManager userManager;
    private final String logPath;

    public EventLogger(GameLogger logger, IUserManager userManager) {
        this.logger = logger;
        this.userManager = userManager;
        this.logPath = ServiceLocator.getResources().getLogPath();
        this.writer = new MyFileWriter();
    }

    private String getWritePath(User user) {
        return 
            logPath + "user-" + user.getUsername() + ".log";
    }

    public void log(IGameEvent event) {
        final String message = event.getMessage();
        if (message != null) {
            logger.logEvent(message);
            writeToLogFile(event, getWritePath(userManager.getMe()));
            writeToLogFile(event, getWritePath(Users.GLOBAL));
        }
    }
    
    private void writeToLogFile(IGameEvent event, String path) {
        writer.setPath(path).write(
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
    
    /*
    logging style:
    event timestamp event_description
    select 2020....20:22:20 card.mage 
    */
}