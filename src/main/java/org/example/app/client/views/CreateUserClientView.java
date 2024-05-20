package org.example.app.client.views;

import org.example.app.client.api.ServerApiEndpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateUserClientView {
    private final Scanner scanner;
    private final ServerApiEndpoints serverApiEndpointsUnit;

    public CreateUserClientView(Scanner scanner,ServerApiEndpoints serverApiEndpointsUnit ) {
        this.scanner = scanner;
        this.serverApiEndpointsUnit = serverApiEndpointsUnit;
    }

    public void createUserViewProcessing() {
        while (true) {
            String createUserMenu = """
                    
                    Create user menu
                    
                    1. Create user
                    2. Back
                    """;
            System.out.println(createUserMenu);
            System.out.print("Select action: ");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    List<String> createData = new ArrayList<>();
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    createData.add(firstName);
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    createData.add(lastName);
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    createData.add(email);
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    createData.add(phone);
                    String response = this.serverApiEndpointsUnit.addUserData(createData.toArray(new String[0]));
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

