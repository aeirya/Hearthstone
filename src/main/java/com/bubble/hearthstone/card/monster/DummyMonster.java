package com.bubble.hearthstone.card.monster;

import com.bubble.hearthstone.card.Minion;
import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class DummyMonster extends Monster {

    private final GameLogger logger;

    public DummyMonster(Minion card) {
        super(card);
        logger = ServiceLocator.getLogger();
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
}