package xoxo.client.ui;

import java.io.PrintWriter;
import java.util.Scanner;

import xoxo.client.net.ServerAPI;
import xoxo.client.ui.command.IMenuLauncher;
import xoxo.client.ui.command.MenuType;
import xoxo.client.ui.menu.GameMenu;
import xoxo.client.ui.menu.LoginMenu;
import xoxo.client.ui.menu.MainMenu;
import xoxo.client.ui.menu.Menu;
import xoxo.client.ui.menu.ReplayMenu;

public class CliGraphics implements IMenuLauncher {
    private final ServerAPI net;
    private final Scanner in;
    private final PrintWriter out;
    private Menu menu;
    private boolean isGettingInput = false;

    public CliGraphics(ServerAPI net) {
        this.net = net;
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        launch(MenuType.LOGIN);
        run();
    }

    private void run() {
        new Thread(() -> {
            clear();
            credits();
            updater();
            while (true) {
                getInput();
                refresh();
            }
        }).start();
    }

    private void credits() {
        printLine();
        out.println("welcome to XOXO!");
        printLine();
        out.print("press enter to continue.. ");
        out.flush();
        in.nextLine();
    }

    private void updater() {
        new Thread(
            () -> {
                while(true) {
                    if ( !isGettingInput && menu.needsRefresh()) {
                        refresh();
                    }
                    sleep();
                }
            }
        ).start();
    }

    private void sleep() {
        menu.sleep();
    }

    private void getInput() {
        final int cmd = in.nextInt();
        in.nextLine();
        isGettingInput = true;
        if (menu.hasCommand(cmd)) {
            refresh();
            menu.getCommand(cmd).takeArgs(in, out).act(net);
        } else {
            clear();
        }
        isGettingInput = false;
    }

    private void refresh() {
        in.reset();
        clear();
        menu.print(out);
        help();
    }

    private void clear() {
        out.print("\033[H\033[2J");
        out.flush();
    }

    private void printLine() {
        out.println("---------------------------");
    }

    private void help() {
        printLine();
        menu.printCommands(out);
        printLine();
        out.flush();
    }

    public static void main(String[] args) {
        new CliGraphics(null);
    }

    @Override
    public void launch(MenuType type) {
        if (menu != null) menu.kill();
        switch(type) {
            case LOGIN:
            menu = new LoginMenu(this);
            break;
            default:
            case MAIN:
            menu = new MainMenu(this, net);
            break;
            case GAME:
            menu = new GameMenu(net, this);
            break;
            case REPLAY:
            menu = new ReplayMenu(net, this);
            break;
        }
        clear();
    }
}