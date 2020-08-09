package xoxo.server;

import java.util.LinkedList;

import xoxo.game.Game;
import xoxo.game.Player;
import xoxo.game.Sign;
import xoxo.net.request.user.IUserManager;
import xoxo.net.response.OkResponse;
import xoxo.server.net.INetwork;
import xoxo.server.user.OnlineUser;

public class MatchFinder {
    private final LinkedList<OnlineUser> inQueue;
    private final IUserManager usermanager;
    private final INetwork net;
    private boolean isAlive = true;

    public MatchFinder(IUserManager usermanager, INetwork net) {
        inQueue = new LinkedList<>();
        this.net = net;
        this.usermanager = usermanager;
        new Thread(this::run).start();
    }

    public void run() {
        while (isAlive) {
            while (inQueue.size() > 1) {
                match();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public boolean queue(String username) {
        final OnlineUser player = usermanager.getOnlineUser(username);
        if (player == null) return false;
        System.out.println("queueing for " + username);
        inQueue.add(player);
        player.setInMatch(false);
        return true;
    }

    public void match() {
        OnlineUser u1 = pick();
        OnlineUser u2 = pick();
        Player p1 = toPlayer(u1);
        Player p2 = toPlayer(u2);
        Game game = new Game(p1, p2);
        u1.startMatch(game, p1);
        u2.startMatch(game, p2);
        game.setHomePlayer(Sign.X);
        System.out.println("match started");
        notifyClients(u1, u2);
    }

    private void notifyClients(OnlineUser u1, OnlineUser u2) {
        net.respond(new OkResponse().toString(), u1.getAuth());
        net.respond(new OkResponse().toString(), u2.getAuth());
    }

    public OnlineUser pick() {
        return inQueue.removeFirst();
    }

    public Player toPlayer(OnlineUser user) {
        return new Player(user.getUsername());
    }
}
