package xoxo.client.net;

// import xoxo.game.Save;
import xoxo.net.request.NetRequest;
import xoxo.net.request.Request;
// import xoxo.net.request.game.GameState;
// import xoxo.net.request.game.GetSaveRequest;
// import xoxo.net.request.game.GetUpdateRequest;
// import xoxo.net.request.game.PlayRequest;
// import xoxo.net.request.menu.GetScoreboardRequest;
// import xoxo.net.request.menu.MatchFinishedRequest;
// import xoxo.net.request.menu.ScorebaordState;
import xoxo.net.request.user.LoginRequest;
import xoxo.net.request.user.LogoutRequest;
import xoxo.net.request.user.SignupRequest;
import xoxo.net.response.NetResponse;
import xoxo.net.response.Response;

public class ServerAPI {
    private final Network net;
    private String username;
    private String password; // this could be removed
    
    public ServerAPI(Network net) {
        this.net = net;
    }

    private void log(Response response) {
        System.out.println(response.body);
    }

    private void log() {
        System.out.println(
            net.getResponse()
        );
    }

    private void dump() {
        net.getResponse();
    }

    public void login(String username, String password) {
        net.request(new LoginRequest(username, password));
        final Response response = net.getResponse();
        if (response.type == NetResponse.OK) {
            this.username = username;
            this.password = password;
        }
        log(response);
    }

    public void logout() {
        net.request(new LogoutRequest(username, password));
        dump();
    }

    public void singup(String username, String password) {
        net.request(new SignupRequest(username, password));
        dump();
    }

    public void findMatch() {
        net.request(new Request(NetRequest.FIND_MATCH, username));
        dump();
    }

    // public void play(int x, int y) {
    //     net.request(new PlayRequest(x + "," + y));
    //     log();
    // }

    public synchronized Response getResponse() {
        return net.getResponse();
    }

    // public GameState getUpdate() {
    //     net.request(new GetUpdateRequest());
    //     final Response response = getResponse();
    //     if (response.type.equals(NetResponse.OK)) {
    //         return new GameState(response.body);
    //     } else {
    //         return null;
    //     }
    // }

    public String getUsername() {
        return username;
    }

    // public ScorebaordState getScoreboard() {
    //     net.request(new GetScoreboardRequest());
    //     final Response r = getResponse();
    //     return new ScorebaordState(r.body);
    // }

    // public void finishMatch() {
    //     net.request(new MatchFinishedRequest());
    //     dump();
    // }

    // public Save getReplay() {
    //     net.request(new GetSaveRequest());
    //     final Response r = getResponse();
    //     if(r.body != null) {
    //         return new Save(r.body);
    //     } else return null;
    // }
}