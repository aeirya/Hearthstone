package com.bubble.hearthstone.model.arena;

import com.bubble.hearthstone.card.monster.Monster;
import com.bubble.hearthstone.net2.event.events.arena.battleground.BattlegroundEvent;

public class CombatMaster {
    
    private final RuleBook ruleBook;

    public CombatMaster() {
        // could load combat rules here
        this.ruleBook = new RuleBook();
    }

    public void handleEvent(BattlegroundEvent event) {
        event.process(this);
    }

    public void attack(Monster attacker, Monster defender) {
        // check rules
        if (!ruleBook.canAttack(attacker, defender)) return; // alert: can not attack 
        attacker.attack(defender);
    }
}