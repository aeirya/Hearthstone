package com.bubble.hearthstone.card.monster;

import java.awt.Graphics;

import com.bubble.hearthstone.card.Minion;
import com.bubble.hearthstone.interfaces.Drawable;

public abstract class Monster implements Drawable {
    private final MonsterView view;
    private final Minion card;

    public Monster(Minion card) {
        this.card = card;
        this.view = new MonsterView(this);
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


    @Override
    public void draw(Graphics g) {
        view.draw(g);
    }

    public MonsterView getView() {
        return view;
    }

    Minion getCard() {
        return card;
    }
}