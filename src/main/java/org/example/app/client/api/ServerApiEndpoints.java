package org.example.app.client.api;

import jakarta.xml.ws.Service;
import org.example.app.client.config.ConfigClient;
import org.example.app.server.services.Interfaces.SOAPServerInterface;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ServerApiEndpoints {
    SOAPServerInterface dataService;

    public ServerApiEndpoints() throws MalformedURLException {
        URL soapUrl = URI.create(ConfigClient.WSDL_URL).toURL();
        QName qName = new QName(ConfigClient.SERVICE_URI, ConfigClient.SERVICE_IMPL);
        Service service = Service.create(soapUrl, qName);
        this.dataService = service.getPort(SOAPServerInterface.class);
    }
    public String getAllUsersData() {
        return dataService.getAllUsers();
    }

    public String getUserDataById(String idUser) {
        return dataService.getUserById(idUser);
    }

    public String addUserData(String[] createdUserData) {
        return dataService.addUser(createdUserData);
    }

    public String updateUserData(String[] updatedUserData) {
        return dataService.updateUser(updatedUserData);
    }

    public String deleteUserData(String idUser) {
        return dataService.deleteUser(idUser);
    }
}
