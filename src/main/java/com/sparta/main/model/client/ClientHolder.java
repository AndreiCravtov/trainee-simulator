package com.sparta.main.model.client;

import java.util.List;

public class ClientCollection {

    public List<Client> clients;

    public void addClient(Client client) {
        clients.add(client);
    }
}
