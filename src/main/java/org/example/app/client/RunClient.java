package org.example.app.client;

import org.example.app.client.clientInit.ClientInit;

public class RunClient {
    private static final ClientInit clientInit = new ClientInit();

    private static void runClient() {
        clientInit.clientInit();
    }

    public static void main(String[] args) {
        runClient();
    }
}
