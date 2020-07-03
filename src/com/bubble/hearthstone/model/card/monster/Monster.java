package com.bubble.hearthstone.model.card.monster;


import com.bubble.hearthstone.model.card.Minion;

public abstract class Monster {

    private final Minion card;
    private int hp;
    private int attack;
    private int defense;

    public Monster(Minion card) {
        this.card = card;
        attack = card.attack;
        defense = card.defense;
    }

    private int getDamageValue() {
        return attack;
    }

    private int getDefenseValue() {
        return defense;
    }

    public void attack(Monster other) {
        onAttack(other);
        other.getAttacked(this, attack);
    }

    public void getAttacked(Monster from, int damage) {
        onGettingDamage(from);
        reduceHealth(damage);
    }

    private void reduceHealth(int value) {
        hp -= value;
    }

    protected abstract void onSummon();
    protected abstract void onAttack(Monster to);
    protected abstract void onGettingDamage(Monster from);

    Minion getCard() {
        return card;
    }
}