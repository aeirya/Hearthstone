package com.bubble.hearthstone.input;

import java.util.Random;

import com.bubble.hearthstone.app.Hearthstone;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.BroadcastMessageEvent;
import com.bubble.hearthstone.net.event.events.DeleteUserEvent;
import com.bubble.hearthstone.net.event.events.HelpEvent;
import com.bubble.hearthstone.net.event.events.IdleEvent;
import com.bubble.hearthstone.net.event.events.LoginEvent;
import com.bubble.hearthstone.net.event.events.LogoutEvent;
import com.bubble.hearthstone.net.event.events.SignupEvent;
import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

public enum EnumCommands implements ICommand {
    LOGIN {
        public IGameEvent toEvent(String... args) {
            if (args.length < 2) {
                return warning(InputError.PROVIDE_USER_INFO);
            }
            return new LoginEvent(args[0], args[1]);
        }
        
        public String getDescription() {
            return "login to the game";
        }
    }, 
    SIGNUP {
        public IGameEvent toEvent(String... args) {
            if (args.length < 2) {
                return warning(InputError.PROVIDE_USER_INFO);
            }
            return new SignupEvent(args[0], args[1]);
        }
        public String getDescription() {
            return "register a new user";
        }
    }, 
    DELETE_USER {
        public IGameEvent toEvent(String... args) {
            if (args.length < 2) {
                return warning(InputError.PROVIDE_USER_INFO);
            }
            return new DeleteUserEvent(args[0], args[1]);
        }
        public String getDescription() {
            return "delete a user";
        }
    },
    LOGOUT {
        public IGameEvent toEvent(String... args) {
            return new LogoutEvent(args);
        }

        public String getDescription() {
            return "log out of the game";
        }
    },
    HELP {
        public IGameEvent toEvent(String... args) {
            return new HelpEvent();
        }

        public String getDescription() {
            return "prints help";
        }
    },
    LIST {
        public IGameEvent toEvent(String... args) {
            return new IdleEvent();
        }

        public String getDescription() {
            return "lists usernames";
        }
    },
    QUIT {

        @Override
        public IGameEvent toEvent(String... args) {
            if (rand(5)) Hearthstone.quit();
            if (rand(2)) return new BroadcastMessageEvent("muhahaaha i'm not leaving");
            else return new BroadcastMessageEvent("oh come onnn!");
        }

        final Random rand = new Random();

        private boolean rand(int unlikeliness) {
            return rand.nextInt(unlikeliness) == 0;
        }

        @Override
        public String getDescription() {
            return "don't you dare write that :(";
        }
    };

    private static final GameLogger logger = ServiceLocator.getLogger();

    private static IGameEvent warning(InputError error) {
        logger.warning(error.toString());
        return null;
    }

    private enum InputError {
        PROVIDE_USER_INFO("you must provide both username and password");

        InputError(String message) {
            this.message = message;
        }
        
        private final String message;
        
        @Override
        public String toString() {
            return message;
        }
    }
}