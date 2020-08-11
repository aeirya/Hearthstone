package com.bubble.net.connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class DataDispacher implements IConnectionDispatcher {

    private final Socket socket;

    public DataDispacher(Socket socket) {
        this.socket = socket;
    }

    private DataOutputStream getOutStream() throws IOException {
        return new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void send(byte[] data) {
        try {
            final DataOutputStream out = getOutStream();
            out.writeInt(data.length);
            out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}