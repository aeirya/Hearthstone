package com.bubble.hearthstone.model.card.monster;

import java.awt.Graphics;

import com.bubble.hearthstone.model.card.Minion;

public abstract class Monster {

    private final Minion card;

    public Monster(Minion card) {
        this.card = card;
    }

    private int getDamageValue() {
        return this.card.attack;
    }

    private int getDefenseValue() {
        return this.card.defense;
    }

    public void attack(Monster other) {
        onAttack(other);
        other.getAttacked(this);
    }

    public void getAttacked(Monster from) {
        onGettingDamage(from);
    }

    private void reduceHealth(int value) {
        //
    }

    protected abstract void onSummon();
    protected abstract void onAttack(Monster to);
    protected abstract void onGettingDamage(Monster from);

    Minion getCard() {
        return card;
    }
}