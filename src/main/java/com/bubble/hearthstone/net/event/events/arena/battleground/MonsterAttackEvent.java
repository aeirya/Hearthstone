// package com.bubble.hearthstone.net.event.events.arena.battleground;

// import com.bubble.hearthstone.card.monster.Monster;
// import com.bubble.hearthstone.model.arena.CombatMaster;

// public class MonsterAttackEvent extends BattlegroundEvent {

//     private final Monster attacker;
//     private final Monster defender;

//     public MonsterAttackEvent(Monster attacker, Monster defender) {
//         this.attacker = attacker;
//         this.defender = defender;
//     }

//     @Override
//     public void process(CombatMaster combatMaster) {
//         combatMaster.attack(attacker, defender);
//     }
// }