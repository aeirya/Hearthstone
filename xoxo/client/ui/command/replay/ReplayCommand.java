package xoxo.client.ui.command.replay;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.ui.ICommand;
import xoxo.client.ui.command.Command;

public abstract class ReplayCommand extends Command {

    protected final IReplayer menu;

    public ReplayCommand(String msg, IReplayer menu) {
        super(msg);
        this.menu = menu;
    }

    @Override
    public ICommand takeArgs(Scanner in, PrintWriter out) {
        return this;
    }
}