package xoxo.client.ui.command.user;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.ui.ICommand;
import xoxo.client.ui.command.Command;

public abstract class UserCommand extends Command {
    
    protected String username = "";
    protected String password = "";

    public UserCommand(String label) {
        super(label);
    }

    @Override
    public ICommand takeArgs(Scanner in, PrintWriter out) {
        while (username.equals("")) {
            out.print("enter username: ");
            out.flush();
            username = in.nextLine();
        }
        while (password.equals("")) {
            out.print("enter password: ");
            out.flush();
            password = in.nextLine();
        }
        return this;
    }
}