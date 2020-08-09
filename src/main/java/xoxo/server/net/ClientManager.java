package xoxo.server.net;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class ClientManager {
    private final Map<String, Client> clients;
    private final SecureRandom random;

    public ClientManager() {
        clients = new HashMap<>();
        random = new SecureRandom();
    }
    public void add(Client client) {
        // i could change this
        client.setAuth(generateAuth());
        clients.put(client.getAuth(), client);
        client.start();
    }

    private String generateAuth() {
        final byte[] bytes = new byte[10];
        random.nextBytes(bytes);
        return new String(bytes);
    }

    public Client find(String auth) {
        return clients.get(auth);
    }
}
