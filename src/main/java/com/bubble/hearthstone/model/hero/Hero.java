package com.bubble.hearthstone.model.hero;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.card.Ability;

public class Hero {
    protected int hp;
    protected final List<Ability> abilities;
    
    private boolean isUnlocked = true;
    
    private Hero() {
        this.hp = 0;
        abilities = new ArrayList<>(); 
        //TODO: initiate hero like a hero :p
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public boolean reduceHp(int x) {
        hp -= x;
        return hp < 0;
    }

    public enum HeroClass {
        MAGE, WARLOCK, ROUGE
    }
}
