package org.example.app.client.views;

import org.example.app.client.api.ServerApiEndpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateUserClientView {
    private final Scanner scanner;
    private final ServerApiEndpoints serverApiEndpointsUnit;

    public UpdateUserClientView(Scanner scanner, ServerApiEndpoints serverApiEndpointsUnit) {
        this.scanner = scanner;
        this.serverApiEndpointsUnit = serverApiEndpointsUnit;
    }

    public void createUserViewProcessing() {
        while (true) {
            String updateUserMenu = """
                   
                    Update user menu
                   
                    1. Update user by id
                    2. Back
                    """;
            System.out.println(updateUserMenu);
            System.out.print("Select action: ");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    List<String> updateData = new ArrayList<>();
                    System.out.print("Enter id: ");
                    String id = scanner.nextLine();
                    String isUserExists = serverApiEndpointsUnit.getUserDataById(id);
                    if (isUserExists.equals("No users found")) {
                        System.out.println(isUserExists);
                        break;
                    } else {
                        System.out.println("User found: " + isUserExists);
                        updateData.add(id);
                    }
                    System.out.print("Enter first name (if update unnecessary press Enter): ");
                    String firstName = scanner.nextLine();
                    updateData.add(firstName);
                    System.out.print("Enter last name (if update unnecessary press Enter): ");
                    String lastName = scanner.nextLine();
                    updateData.add(lastName);
                    System.out.print("Enter email (if update unnecessary press Enter): ");
                    String email = scanner.nextLine();
                    updateData.add(email);
                    System.out.print("Enter phone (if update unnecessary press Enter): ");
                    String phone = scanner.nextLine();
                    updateData.add(phone);
                    String response = this.serverApiEndpointsUnit.updateUserData(updateData.toArray(new String[0]));
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
