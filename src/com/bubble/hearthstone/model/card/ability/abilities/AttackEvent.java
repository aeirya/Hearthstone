package com.bubble.hearthstone.model.card.ability.abilities;

import com.bubble.hearthstone.model.card.monster.Monster;
import com.bubble.hearthstone.module.audio.ISoundEvent;
import com.bubble.hearthstone.module.event.Event;
import com.bubble.hearthstone.module.event.EventType;
import com.bubble.hearthstone.module.logic.arena.CombatMaster;
import com.bubble.hearthstone.module.logic.arena.IBattleEvent;

public class AttackEvent extends Event implements IBattleEvent, ISoundEvent {
    
    private final Monster attacker;
    private final Monster defender;

    public AttackEvent(Monster attacker, Monster defender) {
        super(EventType.ATTACK);
        this.attacker = attacker;
        this.defender = defender;
    }

    @Override
    public void process(CombatMaster master) {
        master.attack(this);
    }

    public Monster getAttacker() {
        return attacker;
    }

    public Monster getDefender() {
        return defender;
    }
}