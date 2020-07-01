package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.input.ICommand;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class MenuCommands {
        
    protected final Map<String, ICommand> mapper;

    MenuCommands() {
        mapper = new LinkedHashMap<>();
    }

    String getCommands() {
        final StringBuilder builder = new StringBuilder();
        mapper.forEach((k,v) -> builder.append(
            "\n" + "[" + k + "]" + " : " + v.getDescription())
            );
        return builder.toString();
    }

    Map<String, ICommand> getMapper() {
        return mapper;
    }
}