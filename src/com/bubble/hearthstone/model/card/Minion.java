package com.bubble.hearthstone.model.card;

import com.bubble.hearthstone.util.serialize.CardSerializer;
import com.bubble.hearthstone.util.serialize.Serializable;

public class Minion implements Serializable {

    public final Card card;
    public final int hp;
    public final int attack;
    public final int defense;
    
    public Minion(Card card, int hp, int attack, int defense) {
        this.card = card;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public static void main(String[] args) {
        final String s = new CardSerializer().serialize(
            new DummyMinion()
        );
        System.err.println(s);
    }
}