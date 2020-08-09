package xoxo.net.connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class DataConnectionDispacher implements IConnectionDispatcher {

    private final Socket socket;

    public DataConnectionDispacher(Socket socket) {
        this.socket = socket;
    }

    private DataOutputStream getOutStream() throws IOException {
        final OutputStream out = socket.getOutputStream();
        return new DataOutputStream(out);
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

    @Override
    public void connect() {
        //
    }
}