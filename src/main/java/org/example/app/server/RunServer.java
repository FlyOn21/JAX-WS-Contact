package org.example.app.server;

import org.example.app.server.initServer.InitServer;

public class RunServer {
    private static final InitServer initServer = new InitServer();

    private static void runServer() {
        initServer.initServerRun();
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Received SIGINT signal. Stopping server...");
                initServer.initServerStop();
        }));
        runServer();
    }
}
