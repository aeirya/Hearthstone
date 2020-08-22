package xoxo.net.request.menu;

import com.bubble.net.response.Response;

import xoxo.net.request.Request;
import xoxo.server.MatchFinder;

public class FindMatchRequest extends Request {

    private String username;

    public FindMatchRequest(String username) {
        this.username = username;
    }

    private String getUsername() {
        return username;
    }
    
    public Response apply(MatchFinder matchFinder) {
        return new Response(
            matchFinder.queue(getUsername())
        );
    }
}