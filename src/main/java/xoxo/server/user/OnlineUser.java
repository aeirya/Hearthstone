package xoxo.server.user;

// import xoxo.game.Game;
// import xoxo.game.Player;

public class OnlineUser {
    private final String username;
    private boolean isInMatch = false;
    private boolean isInQueue = false; 
    // private Game match = null;
    // private Player player = null;
    private String auth;
    
    public OnlineUser(String username) {
        this.username = username;
        auth = null;
    }

    public String getUsername() {
        return username;
    }

    public String getAuth() {
        return auth;
    } 
    
    public void setInQueue(boolean isInQueue) {
        this.isInQueue = isInQueue;
    }

    public void setInMatch(boolean isInMatch) {
        this.isInMatch = isInMatch;
    }

    public boolean isInQueue() {
        return isInQueue;
    }

    public boolean isInMatch() {
        return isInMatch;
    }

    // public void startMatch(Game game, Player player) {
    //     this.setInQueue(false);
    //     this.setInMatch(true);
    //     this.player = player;
    //     this.match = game;
    // }

    // public Game getMatch() {
    //     return match;
    // }

    // public Player getPlayer() {
    //     return player;
    // }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}