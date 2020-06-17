package com.bubble.hearthstone.model.hero;

import java.util.ArrayList;
import java.util.List;

public class HeroPlayer {
    private final Hero hero;
    private final List<HeroEffect> currentEffects;

    public HeroPlayer(Hero hero) {
        this.hero = hero;
        this.currentEffects = new ArrayList<>();
    }

    public void doSpecialPower() {
        hero.getSpecialPower().act(hero);
    }

    public void doHeroPower() {
        hero.getHeroPower().act(hero);
    }

    public void doEffects() {
        currentEffects.forEach(
            effect -> {
                effect.doEffect();
                if (effect.isFinished()) {
                    currentEffects.remove(effect);
                }
            }
        );
    }

    public void equipWeapon(HeroWeapon weapon) {
        hero.setWeapon(weapon);
    }

    public void useWeapon(HeroPlayer other) {
        hero.getWeapon().attack(other);
    }
}