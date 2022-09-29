package com.sparta.main.model.client;

import java.util.ArrayList;
import java.util.List;

public class ClientHolder {

    private final List<Client> clients;
    private int unhappyClients = 0;

    public List<Client> getClients() { return clients; }
    public int getUnhappyClients() { return unhappyClients; }

    public ClientHolder() {
        clients = new ArrayList<>();
    }

    public boolean canAdd(Client client) { return client != null; }

    public boolean addClient(Client client) {
        if (!canAdd(client)) return false;
        return clients.add(client);
    }

    public void removeUnhappyClients() {
        for (Client client: clients) {
            if (client.isUnhappy()) {
                clients.remove(client);
                unhappyClients++;
            }
        }
    }
}
