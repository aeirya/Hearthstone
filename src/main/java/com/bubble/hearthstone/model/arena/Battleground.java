package com.bubble.hearthstone.model.arena;

import java.awt.Graphics;
import java.util.List;

import com.bubble.hearthstone.card.monster.Monster;
import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.model.Player;

/**
 * representing the "table" in the middle of screen
 */
public class Battleground implements Drawable {

    private final List<Monster> friend;
    private final Board board;

    public Battleground(Player player) {
        friend = player.getMonsters();
        board = new Board(friend);
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void draw(Graphics g) {
        friend.forEach(monster -> monster.draw(g));
    }
}