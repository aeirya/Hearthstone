package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.net.event.IGameEvent;

public interface ICliInputParser {
    IGameEvent parse(String text);
}