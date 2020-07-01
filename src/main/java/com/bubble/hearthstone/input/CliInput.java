// package com.bubble.hearthstone.input;

// import com.bubble.hearthstone.net.client.GameClient;
// import com.bubble.hearthstone.net.event.IGameEvent;
// import com.bubble.hearthstone.ui.IGameGraphics;
// import com.bubble.hearthstone.ui.cli.CliMenu;
// import java.util.Arrays;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;
// import java.util.Scanner;
// import java.util.function.Supplier;

// public class CliInput implements IInput {
    
//     private final CliInputParser inputParser;
//     private final GameClient client;
//     private final IGameGraphics graphics;

//     //todo: replace manager by an event handler
//     public CliInput(GameClient client, IGameGraphics graphics) {
//         inputParser = new CliInputParser();
//         this.client = client;
//         this.graphics = graphics;
//     }

//     public void start() {
//         new Thread(this::run).start();
//     }
    
//     private void run() {
//         final Scanner scanner = new Scanner(System.in);
//         while (scanner.hasNext()) {
//             final String line = scanner.nextLine();
//             final IGameEvent e = inputParser.parse(line);
//             if (e != null) this.handleEvent(e);
//             else graphics.error("unacceptable input! write \"help\" for help");
//         }   
//         scanner.close();
//     }
    
//     private void handleEvent(IGameEvent e) {
//         if (e == null) return;
//         client.handleEvent(e);

//     }

//     private class CliInputParser {
        
//         private Map<String, ICommand> getMapper() {
//             return ((CliMenu)(graphics.getCurrentMenu())).getMapper();
//         }

//         IGameEvent parse(String input) {
//             final LinkedList<String> list = split(input);
//             return eventSupplier(list).get();
//         }
        
//         private LinkedList<String> split(String input) {
//             final List <String> split = Arrays.asList(input.split(" "));
//             return new LinkedList<>(split);
//         }
        
//         private Supplier<IGameEvent> eventSupplier(LinkedList<String> list) {
//             final String key = list.removeFirst();
//             final ICommand command = toCommand(key);
//             if (command == null) {
//                 return () -> null;
//             }
//             final String[] args = list.toArray(new String[0]);
//             return () -> command.toEvent(args);
//         }

//         private ICommand toCommand(String text) {
//             return getMapper().getOrDefault(text, null);
//         }
//     }
// }