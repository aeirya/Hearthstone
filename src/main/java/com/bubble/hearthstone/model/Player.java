package com.bubble.hearthstone.model;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.card.Minion;
import com.bubble.hearthstone.card.monster.DummyMonster;
import com.bubble.hearthstone.card.monster.Monster;
import com.bubble.hearthstone.model.arena.Hand;
import com.bubble.hearthstone.net.user.UserSave;

public class Player {
    
    private final String name;
    private final Hand hand;
    private final List<Monster> monsters;

    public Player(UserSave save) {
        this.name = save.getUser().getUsername();
        this.monsters = new ArrayList<>();
        this.hand = new Hand(
            save.getCurrentDeck()
        );
    }
    
    public Hand getHand() {
        return hand;
    }

    public void summon(Card card) {
        monsters.add(
            new DummyMonster(
                new Minion(1, 1, 1, "minie", 2, "HHHHH")
            )
        ); 
        //oops this is awkward!!
    }

    public List<Monster> getMonsters() {
        // implement this
        return monsters;
    }

    public String getName() {
        return name;
    }
}