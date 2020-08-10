package xoxo.client.ui.command;

import java.io.PrintWriter;

import xoxo.client.ui.ICommand;

public abstract class Command implements ICommand {

    private final String msg;

    public Command(String msg) {
        this.msg = msg;
    }

    public void print(int index, PrintWriter out) {
        out.println(index + ": " + msg);
    }
}