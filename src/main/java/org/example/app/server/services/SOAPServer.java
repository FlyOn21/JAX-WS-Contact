package org.example.app.server.services;

import jakarta.jws.WebService;
import org.example.app.app.db_connect.DbConnectInit;
import org.example.app.app.views.*;
import org.example.app.server.services.Interfaces.SOAPServerInterface;


@WebService(endpointInterface = "org.example.app.server.services.Interfaces.SOAPServerInterface")
public class SOAPServer implements SOAPServerInterface {
    private final DbConnectInit connection;
    public SOAPServer(DbConnectInit connection) {
        this.connection = connection;
    }
    @Override
    public String getAllUsers() {
        GetUsersView getUsersView = new GetUsersView(this.connection);
        return getUsersView.getUsersViewProcessing();
    }
    @Override
    public String getUserById(String idUser) {
        GetUserByIdView getUserByIdView = new GetUserByIdView(this.connection);
        return getUserByIdView.getUserByIdProcessing(idUser);
    }
    @Override
    public String addUser(String[] createdUserData) {
        CreateUserView createUserView = new CreateUserView(this.connection);
        return createUserView.createUserViewProcessing(createdUserData);
    }
    @Override
    public String updateUser(String[] updatedUserData) {
        UpdateUserView updateUserView = new UpdateUserView(this.connection);
        return updateUserView.updateUserViewProcessing(updatedUserData);
    }
    @Override
    public String deleteUser(String idUser) {
        DeleteUserView deleteUserView = new DeleteUserView(this.connection);
        return deleteUserView.deleteUserViewProcessing(idUser);
    }
}
