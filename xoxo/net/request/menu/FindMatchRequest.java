package xoxo.net.request.menu;

import com.bubble.net.response.Response;

import xoxo.net.request.Request;
import xoxo.server.MatchFinder;

public class FindMatchRequest extends Request {

    public FindMatchRequest(Request request) {
        super(request);
    }

    private String getUsername() {
        return body;
    }
    
    public Response apply(MatchFinder matchFinder) {
        return new Response(
            matchFinder.queue(getUsername())
        );
    }
}