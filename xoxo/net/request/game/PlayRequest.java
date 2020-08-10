package xoxo.net.request.game;

import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.request.NetRequest;
import com.bubble.net.response.Response;

import xoxo.game.Game;
import xoxo.game.Player;
import xoxo.net.request.Request;

public class PlayRequest extends Request {

    public PlayRequest(Request request) {
        super(request);
    }

    public PlayRequest(String body) {
        super(NetRequest.PLAY, body);
    }

    public Response apply(OnlineUser user) {
        if (! user.isInMatch()) return new Response(false);
        return apply(user.getMatch(), user.getPlayer());
    }

    private Response apply(Game game, Player player) {
        final String[] split = body.split(",");
        final int x = Integer.parseInt(split[0]);
        final int y = Integer.parseInt(split[1]);
        final boolean result = game.play(player, x, y); 
        return new Response(result);
    } 
}