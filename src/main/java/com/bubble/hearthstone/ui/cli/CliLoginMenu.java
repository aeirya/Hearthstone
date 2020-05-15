package com.bubble.hearthstone.ui.cli;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bubble.hearthstone.input.EnumCommands;
import com.bubble.hearthstone.input.ICommand;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.IdleEvent;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class CliLoginMenu extends CliMenu {

    private IGameGraphics graphics;
    private CliInputParser inputParser;

    public CliLoginMenu() {
        this.inputParser = new CliInputParser();
    }

    @Override
    public void lunch(IGameGraphics graphics) {
        super.lunch(graphics);
        this.graphics = graphics;
        printCommands();
    }

    @Override
    public void printCommands() {
        graphics.message(
            getCommands()
        );
    }

    private String getCommands() {
        return inputParser.getCommands();
    }

    private class CliInputParser {
        
        private final Map<String, EnumCommands> mapper;

        CliInputParser() {
            mapper = new LinkedHashMap<>();
            mapper.put("login", EnumCommands.LOGIN);
            mapper.put("reg" ,EnumCommands.SIGNUP);
            mapper.put("del", EnumCommands.DELETE_USER);
            mapper.put("ls", EnumCommands.LIST);
            mapper.put("out", EnumCommands.LOGOUT);
            mapper.put("help", EnumCommands.HELP);
            mapper.put("quit", EnumCommands.QUIT);
        }

        IGameEvent parse(String input) {
            final List <String> split = Arrays.asList(input.split(" "));
            final LinkedList<String> list = new LinkedList<>(split);
            final String key = list.removeFirst();
            final ICommand command = getCommand(key);
            if (command == null) return new IdleEvent();
            final String[] args = list.toArray(new String[0]);
            return command.toEvent(args);
        }

        private EnumCommands getCommand(String text) {
            final EnumCommands command = mapper.getOrDefault(text, null);
            if (command == null) graphics.error("unacceptable input! write \"help\" for help");
            if (command == EnumCommands.HELP) printHelp();
            if (command == EnumCommands.LIST) listPlayers();
            return command;
        }

        void printHelp() {
            final StringBuilder builder = new StringBuilder();
            mapper.forEach((k,v) -> builder.append(
                "\n" + "[" + k + "]" + " : " + v.getDescription())
                );
            graphics.message(builder.toString());
        }

        String getCommands() {
            final StringBuilder builder = new StringBuilder();
            mapper.forEach((k,v) -> builder.append(
                "\n" + "[" + k + "]" + " : " + v.getDescription())
                );
            return builder.toString();
        }

         

        void listPlayers() {
            final StringBuilder builder = new StringBuilder();
            ServiceLocator.getResources().getUsers().keySet().forEach(
                k -> builder.append("\n" + k)
            );
            graphics.message(builder.toString());
        }
    }
}