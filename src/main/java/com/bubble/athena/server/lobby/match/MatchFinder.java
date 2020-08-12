package com.bubble.athena.server.lobby.match;

import java.util.LinkedList;

import com.bubble.athena.server.ServiceLocator;
import com.bubble.athena.server.arena.Game;
import com.bubble.athena.server.arena.GameBuilder;
import com.bubble.athena.server.lobby.IOnlineUserQuery;
import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.response.Response;
import com.bubble.net.server.INetwork;
import com.bubble.util.log.IGameLogger;

public class MatchFinder {
    private final LinkedList<OnlineUser> inQueue;
    private final IOnlineUserQuery usermanager;
    private final INetwork net;
    private final GameBuilder gameBuilder;
    private final IGameLogger logger;
    private boolean isAlive = true;

    public MatchFinder(IOnlineUserQuery usermanager, INetwork net) {
        this.net = net;
        this.usermanager = usermanager;
        logger = ServiceLocator.getLogger();
        gameBuilder = new GameBuilder();
        inQueue = new LinkedList<>();
        new Thread(this::run, "MatchFinder").start();
    }

    private void run() {
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
        logger.log("queueing for " + username);
        inQueue.add(player);
        player.setInMatch(false);
        return true;
    }

    private void match() {
        final OnlineUser u1 = pick();
        final OnlineUser u2 = pick();
        match(u1, u2);
    }

    public void match(OnlineUser u1, OnlineUser u2) {
        resetInQueue(u1, u2);
        setInMatch(u1, u2);
        final Game game = gameBuilder.newGame(u1, u2);
        setGame(u1, u2, game);
        logger.log("match started");
        notifyClients(u1, u2);
    }

    private void resetInQueue(OnlineUser u1, OnlineUser u2) {
        u1.setInQueue(false);
        u2.setInQueue(false);
    }

    private void setInMatch(OnlineUser user1, OnlineUser user2) {
        user1.setInMatch(true);
        user2.setInMatch(true);
    }

    private void setGame(OnlineUser u1, OnlineUser u2, Game game) {
        u1.startMatch(game);
        u2.startMatch(game);
    }

    private void notifyClients(OnlineUser u1, OnlineUser u2) {
        net.respond(Response.OK, u1);
        net.respond(Response.OK, u2);
    }

    public OnlineUser pick() {
        return inQueue.removeFirst();
    }
}
