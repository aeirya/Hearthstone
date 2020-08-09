package xoxo.client.ui.menu;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import xoxo.client.net.ServerAPI;
import xoxo.client.ui.ICommand;

public abstract class Menu {

    private final Map<Integer, ICommand> map;
    protected boolean isNeedsRefresh = true; 
    protected int sleepTime = 400;
    protected final ServerAPI api;
    protected boolean isAlive = true;

    public Menu(ServerAPI api) {
        this.api = api;
        map = new HashMap<>();
        run();
    }

    private void run() {
        new Thread(() -> {
            while (isAlive) {
                update();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void kill() {
        isAlive = false;
    }

    protected void update() {
        // override this
    }

    protected void addCommand(ICommand command) {
        map.put(map.size(), command);
    }

    public ICommand getCommand(int index) {
        return map.get(index);
    }

    public boolean hasCommand(int index) {
        return map.containsKey(index);
    }

    public List<ICommand> getAvailableCommands() {
        return map.keySet().stream().sorted().map(map::get).collect(Collectors.toList());
    }

    public void printCommands(PrintWriter out) {
        IntStream.range(0, map.size()).forEach(i -> map.get(i).print(i, out));
    }

    public void print(PrintWriter out) {
        //
    }

    public boolean needsRefresh() {
        if (isNeedsRefresh) {
            isNeedsRefresh = false;
            return true;
        }
        return false;
    }

    public void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}