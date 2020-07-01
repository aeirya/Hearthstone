package com.bubble.hearthstone.util.net.chat.client;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ChatTransmitter extends Thread {
    
    private final InputStream inputStream;
    private final PrintStream printStream;

    ChatTransmitter(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    @Override
    public void run() {
        final Scanner scanner = new Scanner(inputStream);
        while (!isInterrupted()) {
            final String message = scanner.nextLine();
            printStream.println(message);
        }
    }
}