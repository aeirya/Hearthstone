
package xoxo.client.ui;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.net.ServerAPI;

public interface ICommand {
    ICommand takeArgs(Scanner in, PrintWriter out);
    void print(int index, PrintWriter out);
    void act(ServerAPI api);
}