package com.bubble.hearthstone.model.card;

public class Minion {

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
}