package org.example.app.client.views;


import org.example.app.client.api.ServerApiEndpoints;

import java.util.Scanner;

public class ClientAppMainView {
    private final Scanner scanner;
    private final ServerApiEndpoints serverApiEndpointsUnit;

    public ClientAppMainView(Scanner scanner, ServerApiEndpoints serverApiEndpointsUnit) {
        this.scanner = scanner;
        this.serverApiEndpointsUnit = serverApiEndpointsUnit;
    }

    public void appClientViewProcessing() {
        String title = "Project SOAP User";
        System.out.println(title);
        while (true) {
            String menu = """
                    1. Get all users
                    2. Create user
                    3. Find user by id
                    4. Update user
                    5. Delete user
                    0. Exit
                    """;
            System.out.println(menu);
            System.out.print("Select action: ");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    GetUsersClientView getUsersView = new GetUsersClientView(scanner, serverApiEndpointsUnit);
                    getUsersView.getUsersViewProcessing();
                    break;
                case "2":
                    CreateUserClientView createUserView = new CreateUserClientView(scanner, serverApiEndpointsUnit);
                    createUserView.createUserViewProcessing();
                    break;
                case "3":
                    GetUserByIdClientView getUserByIdView = new GetUserByIdClientView(scanner, serverApiEndpointsUnit);
                    getUserByIdView.getUserByIdProcessing();
                    break;
                case "4":
                    UpdateUserClientView updateUserView = new UpdateUserClientView(scanner, serverApiEndpointsUnit);
                    updateUserView.createUserViewProcessing();
                    break;
                case "5":
                    DeleteUserClientView deleteUserView = new DeleteUserClientView(scanner, serverApiEndpointsUnit);
                    deleteUserView.deleteUserViewProcessing();
                    break;
                case "0":
                    System.out.println("Exit..");
                    return;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }
}
