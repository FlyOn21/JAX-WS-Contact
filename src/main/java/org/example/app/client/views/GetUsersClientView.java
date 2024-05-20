package org.example.app.client.views;

import org.example.app.client.api.ServerApiEndpoints;
import java.util.Scanner;

public class GetUsersClientView {
    private final Scanner scanner;
    private final ServerApiEndpoints serverApiEndpointsUnit;

    public GetUsersClientView(Scanner scanner, ServerApiEndpoints serverApiEndpointsUnit) {
        this.scanner = scanner;
        this.serverApiEndpointsUnit = serverApiEndpointsUnit;
    }

    public void getUsersViewProcessing() {
        while (true) {
            String createUserMenu = """
                    
                    View all users menu

                    1. View all users
                    2. Back
                    """;
            System.out.println(createUserMenu);
            System.out.print("Select action: ");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    String response = this.serverApiEndpointsUnit.getAllUsersData();
                    System.out.println(response);
                    break;
                case "2":
                    System.out.println("Back..");
                    return;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }

}
