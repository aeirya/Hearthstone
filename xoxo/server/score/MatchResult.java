package xoxo.server.score;

public enum MatchResult implements ScoreChanger {
    WIN {
        @Override
        public void apply(Entry entry) {
            entry.win();
        }
    },
    LOST {
        @Override
        public void apply(Entry entry) {
            entry.lose();
        }
    },
    DRAW {
        @Override
        public void apply(Entry entry) {
            // no change
        }
    }
}