
package com.bubble.athena.server.score;

@FunctionalInterface
interface ScoreChanger {
    void apply(Entry entry);
}