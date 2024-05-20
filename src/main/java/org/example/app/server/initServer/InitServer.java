package org.example.app.server.initServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.app.app.controllers.DBController;
import org.example.app.app.db_connect.DbConnectInit;
import org.example.app.app.exceptions.ConnectException;
import org.example.app.server.config.ConfigServer;
import org.example.app.server.services.ServicePublisher;

public class InitServer {
    private static final Logger CONSOLE_LOGGER =
            LogManager.getLogger("console_logger");
    private static final Logger SERVER_HANDLER_LOGGER =
            LogManager.getLogger(InitServer.class);

    private DbConnectInit connection;

    public void initServerRun () {
        DBController appController = new DBController();
        try {
            connection = appController.connect();
            CONSOLE_LOGGER.info(String.format("Db connected - %s", connection));
            SERVER_HANDLER_LOGGER.info(String.format("Db connected - %s", connection));
        } catch (ConnectException e) {
            SERVER_HANDLER_LOGGER.error(e.getMessage());
            System.out.println("Db connect failed. Server start failed");
            System.exit(1);
        }

        CONSOLE_LOGGER.info("Server start");
        SERVER_HANDLER_LOGGER.info("Server start");
        ServicePublisher servicePublisher = new ServicePublisher(connection);
        servicePublisher.publish(ConfigServer.BASE_URL);
    }

    public void initServerStop () {
        CONSOLE_LOGGER.info("Server stop");
        SERVER_HANDLER_LOGGER.info("Server stop");
    }
}
