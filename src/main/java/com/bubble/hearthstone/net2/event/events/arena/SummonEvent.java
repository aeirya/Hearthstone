package com.bubble.hearthstone.net.event.events.arena;

import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.model.Player;

public class SummonEvent extends ArenaEvent {

    private final Card card;
    private final String playerName;

    public SummonEvent(Card card, String player) {
        this.card = card;
        this.playerName = player;
    }

    @Override
    public void process(Arena arena) {
        final Player player = arena.getPlayer(playerName);
        player.summon(card);
    }
}