package xoxo.client.ui.command.game;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.net.ServerAPI;
import xoxo.client.ui.ICommand;
import xoxo.client.ui.command.Command;

public class PlayCommand extends Command {

    private int x;
    private int y;

    public PlayCommand() {
        super("play move");
    }

    @Override
    public ICommand takeArgs(Scanner in, PrintWriter out) {
        out.print("enter x and y: ");
        out.flush();
        x = in.nextInt();
        y = in.nextInt();
        return this;
    }

    @Override
    public void act(ServerAPI api) {
        api.play(x, y);
    }
}