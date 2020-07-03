package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.model.card.ability.abilities.AttackEvent;
import com.bubble.hearthstone.model.card.monster.Monster;
import com.bubble.hearthstone.module.event.IEventHandler;

public class CombatMaster implements IEventHandler {
    
    private final RuleBook ruleBook;

    public CombatMaster() {
        // could load combat rules here
        this.ruleBook = new RuleBook();
    }

    public void attack(AttackEvent event) {
        final Monster attacker = event.getAttacker();
        final Monster defender = event.getDefender();
        // check rules
        if (!ruleBook.canAttack(attacker, defender)) {
            event.cancel();
            // alert: can not attack
        }
        attacker.attack(defender);
    }
}