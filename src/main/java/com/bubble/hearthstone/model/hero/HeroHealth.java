package com.bubble.hearthstone.model.hero;

import com.bubble.hearthstone.stl.ICountable;

public class HeroHealth implements ICountable {

    private final int initialHP;
    private int hp;

    public HeroHealth(int hp) {
        this.initialHP = hp;
        this.hp = hp;
    }

    @Override
    public void decrease(int x) {
        hp -= 1;
    }

    @Override
    public void increase(int x) {
        hp += 1;
    }

    @Override
    public int getValue() {
        return hp;
    }
    
    public boolean isAlive() {
        return hp > 0;
    }

    public void restore(int x) {
        increase(x);
        if (hp > initialHP) hp = initialHP;
    }
}