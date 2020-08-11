package com.bubble.athena.server.lobby;

import java.util.LinkedList;

import com.bubble.athena.server.arena.GameBuilder;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.response.Response;
import com.bubble.net.server.INetwork;

public class MatchFinder {
    private final LinkedList<OnlineUser> inQueue;
    private final IUserManager usermanager;
    private final INetwork net;
    private final GameBuilder gameBuilder;
    private boolean isAlive = true;

    public MatchFinder(IUserManager usermanager, INetwork net) {
        this.net = net;
        this.usermanager = usermanager;
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
        // ("queueing for " + username)
        System.out.println("queueing for " + username);
        inQueue.add(player);
        player.setInMatch(false);
        return true;
    }

    public void match() {
        final OnlineUser u1 = pick();
        final OnlineUser u2 = pick();
        gameBuilder.newGame(u1, u2);
        // ("match started")
        System.out.println("match started");
        notifyClients(u1, u2);
    }

    private void notifyClients(OnlineUser u1, OnlineUser u2) {
        net.respond(Response.OK, u1);
        net.respond(Response.OK, u2);
    }

    public OnlineUser pick() {
        return inQueue.removeFirst();
    }
}
