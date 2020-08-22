
package xoxo.server.score;

@FunctionalInterface
interface ScoreChanger {
    void apply(Entry entry);
}