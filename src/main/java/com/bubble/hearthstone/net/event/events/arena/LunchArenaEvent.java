package com.bubble.hearthstone.net.event.events.arena;

import com.bubble.hearthstone.net.client.GameClient;
import com.bubble.hearthstone.net.event.events.ChangeMenuEvent;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.util.net.facade.Requests;

public class LunchArenaEvent extends ChangeMenuEvent {
    
    public LunchArenaEvent() {
        super(MenuType.ARENA);
    }

    @Override
    public void process(GameClient client) {
        client.sendRequest(Requests.LAUNCH_ARENA);
        // add response check here
        super.process(client);
    }
}