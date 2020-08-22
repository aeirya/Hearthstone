package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.net2.event.IGameEvent;

public interface ICliInputParser {
    IGameEvent parse(String text);
}