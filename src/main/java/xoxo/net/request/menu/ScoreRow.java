package xoxo.net.request.menu;

public class ScoreRow {
    private final int score;
    private final String user;
    private final boolean isOnline;
    private final String status;
    private boolean isMe = false;

    ScoreRow(String user, int score, boolean isOnline, String status) {
        this.user = user;
        this.score = score;
        this.isOnline = isOnline;
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public String getUser() {
       return ! isMe ? user : user + " (you)";
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getStatus() {
        return status;
    }

    public void highlight() {
        isMe = true;
    }
}