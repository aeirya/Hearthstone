package com.bubble.athena.server.arena;

public interface IRulebook {
    boolean canAttack(IMonster attack, IMonster defender);
}