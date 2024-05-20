package org.example.app.server.services;

import jakarta.xml.ws.Endpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.app.app.db_connect.DbConnectInit;

public class ServicePublisher {
    private final DbConnectInit connection;
    private static final Logger CONSOLE_LOGGER =
            LogManager.getLogger("console_logger");

    public ServicePublisher(DbConnectInit connection) {
        this.connection = connection;
    }

    public void publish(String url) {
        Endpoint.publish(url, new SOAPServer(connection));
        CONSOLE_LOGGER.info(String.format("Service published at => %s%n ", url));
    }
}
