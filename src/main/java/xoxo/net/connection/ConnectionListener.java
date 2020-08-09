package xoxo.net.connection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

// replaced by data connection listener
public class ConnectionListener {
    
    private final Socket socket;
    private final NetworkConnection connection;
    private boolean isRunning;

    public ConnectionListener(NetworkConnection connection, Socket socket) {
        this.connection = connection;
        this.socket = socket;
    }

    public void listen() {
        new Thread(this::run).start();
    }

    private void run() {
        isRunning = true;
        final InputStream in = getInStream();
        if (in == null) return;
        
        while (isRunning) {
            final byte[] data = read(in);
            if (data.length > 0) {
                connection.receive(data);
            }
        }
    }

    private InputStream getInStream() {
        try {
            return socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] read(InputStream in, int len) {
        final byte[] data = new byte[len];
        try {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (true) {
                final int count = in.read(data);
                // new DataInputStream(in)
                baos.write(data, 0, count);
                if (count < 0) break;
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private byte[] read(InputStream in) {
        final int len = 0x1000;
        return read(in, len);
    }

    public void terminate() {
        isRunning = false;
        try {
            final InputStream in = getInStream();
            if (in != null) in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}