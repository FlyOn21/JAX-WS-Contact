package org.example.app.client.views;

import org.example.app.client.api.ServerApiEndpoints;
import java.util.Scanner;

public class GetUserByIdClientView {
    private final Scanner scanner;
    private final ServerApiEndpoints serverApiEndpointsUnit;

    public GetUserByIdClientView(Scanner scanner, ServerApiEndpoints serverApiEndpointsUnit) {
        this.scanner = scanner;
        this.serverApiEndpointsUnit = serverApiEndpointsUnit;
    }

    public void getUserByIdProcessing() {
        while (true) {
            String createUserMenu = """
                    
                    View current users by id menu

                    1. View current users by id
                    2. Back
                    """;
            System.out.println(createUserMenu);
            System.out.print("Select action: ");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.print("Enter id: ");
                    String id = scanner.nextLine();
                    String isUserExists = serverApiEndpointsUnit.getUserDataById(id);
                    if (isUserExists.equals("No users found")) {
                        System.out.println(isUserExists);
                        break;
                    } else {
                        System.out.println("User found: " + isUserExists);
                    }
                    break;
                case "2":
                    System.out.println("Back..");
                    return;
                default:
                    System.out.println("Invalid action!");
            }
        }
    }
}
