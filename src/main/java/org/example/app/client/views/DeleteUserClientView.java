package org.example.app.client.views;

import org.example.app.client.api.ServerApiEndpoints;
import java.util.Scanner;

public class DeleteUserClientView {
    private final Scanner scanner;
    private final ServerApiEndpoints serverApiEndpointsUnit;

    public DeleteUserClientView(Scanner scanner, ServerApiEndpoints serverApiEndpointsUnit) {
        this.scanner = scanner;
        this.serverApiEndpointsUnit = serverApiEndpointsUnit;
    }

    public void deleteUserViewProcessing() {
        while (true) {
            String createUserMenu = """

                    Delete user menu

                    1. Delete user by id
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
                            System.out.print("Do you want to delete this user? (yes/no): ");
                            String isDelete = scanner.nextLine();
                            if (!isDelete.equals("yes")) {
                                System.out.println("User not deleted");
                                break;
                            }
                            String deleteUserResult = serverApiEndpointsUnit.deleteUserData(id);
                            System.out.println(deleteUserResult);
                        }
                    break;
                case "2":
                    System.out.println("Back ...");
                    return;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }
}
