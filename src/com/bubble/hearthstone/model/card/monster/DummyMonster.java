package com.bubble.hearthstone.model.card.monster;

import com.bubble.hearthstone.model.card.DummyMinion;

public class DummyMonster extends Monster {

    private final GameLogger logger;

    public DummyMonster() {
        super(new DummyMinion());
        logger = new GameLogger();
    }

    @Override
    protected void onSummon() {
        logger.log("on summon!");
    }

    @Override
    protected void onAttack(Monster to) {
        logger.log("on attack!");
    }

    @Override
    protected void onGettingDamage(Monster from) {
        logger.log("ouch!");
    }

    public class GameLogger {
        public void log(String string) {
            System.out.println(string);
        }
    }
}