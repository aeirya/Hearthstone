package com.bubble.hearthstone.card;

public class Minion extends Card {
    public final int hp;
    public final int attack;
    public final int defense;

    public Minion(int hp, int attack, int defense) {
        this.type = CardType.MINION;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public Minion(
        int hp, int attack, int defense, 
        String name, int manaCost, String description) {
            this(hp, attack, defense);
            this.name = name;
            this.manaCost = manaCost;
            this.description = description;
        }
}