package org.example.app.server.services;

import jakarta.xml.ws.Endpoint;
import org.example.app.app.db_connect.DbConnectInit;

public class ServicePublisher {
    private final DbConnectInit connection;

    public ServicePublisher(DbConnectInit connection) {
        this.connection = connection;
    }

    public void publish(String url) {
        Endpoint.publish(url, new SOAPServer(connection));
        System.out.println("Service published at " + url);
    }
}
