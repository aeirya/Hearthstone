package xoxo.net.connection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

// replcaed by data connection dispatcher
public class ConnectionDispatcher {

    private final Socket socket;

    public ConnectionDispatcher(Socket socket) {
        this.socket = socket;
    }

    public void connect() {
        //
    }

    private OutputStream getOutput() throws IOException {
        return socket.getOutputStream();
    }

    public void send(byte[] data) {
        final OutputStream out;
        try {
            out = getOutput();
            write(out, data);
            flush(out);
            end(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(OutputStream out, byte[] data) throws IOException {
        out.write(data);
    }

    private void flush(OutputStream out) throws IOException {
        out.flush();
    }

    private void end(OutputStream out) throws IOException {
        out.write(Protocol.PROTO_END.getBytes());
    }
}