package org.example.app.client.clientInit;

import org.example.app.client.api.ServerApiEndpoints;
import org.example.app.client.views.ClientAppMainView;

import java.net.MalformedURLException;
import java.util.Scanner;

public class ClientInit {
    private Scanner scanner;
    private ServerApiEndpoints serverApiEndpointsUnit;

    public void clientInit() {
        this.scanner = new Scanner(System.in);
        try {
            this.serverApiEndpointsUnit = new ServerApiEndpoints();
        } catch (MalformedURLException e) {
            this.scanner.close();
            System.out.println("ServerApiEndpoints init failed");
            System.out.println("Check server connection and try again, exiting..");
            clientClose();
        }
        ClientAppMainView clientAppMainView = new ClientAppMainView(scanner, serverApiEndpointsUnit);
        clientAppMainView.appClientViewProcessing();
        clientClose();
    }

    public void clientClose() {
        if (scanner != null) {
            scanner.close();
        }
        System.out.println("Client is off.");
        System.exit(0);
    }
}
