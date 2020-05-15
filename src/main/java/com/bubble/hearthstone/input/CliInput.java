package com.bubble.hearthstone.input;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.IdleEvent;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class CliInput implements IInput {
    
    private final CliInputParser inputParser;
    private final GameManager manager;
    private final IGameGraphics graphics;

    //todo: replace manager by an event handler
    public CliInput(GameManager manager, IGameGraphics graphics) {
        inputParser = new CliInputParser();
        this.manager = manager;
        this.graphics = graphics;
    }

    public void start() {
        new Thread(this::run).start();
    }
    
    private void run() {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String line = scanner.nextLine();
            final IGameEvent e = inputParser.parse(line);
            this.handleEvent(e);
        }   
        scanner.close();
    }

    private void handleEvent(IGameEvent e) {
        if (e != null) manager.networkPush(e);
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

        void listPlayers() {
            final StringBuilder builder = new StringBuilder();
            ServiceLocator.getResources().getUsers().keySet().forEach(
                k -> builder.append("\n" + k)
            );
            graphics.message(builder.toString());
        }
    }
}