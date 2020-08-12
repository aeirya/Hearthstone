package com.bubble.athena.net.arena;

public class AttackEvent implements IArenaEvent {
    private final String attacker;

    public AttackEvent(String attacker) {
        this.attacker = attacker;
    }

    public void test() {
        System.out.println(attacker);
    }
}