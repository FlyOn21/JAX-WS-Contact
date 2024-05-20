package org.example.app.server.config;

public class ConfigServer {
    public static final int PORT = 8189;
    public static final String HOST = "localhost";
    public final static String SERVER_SOAP_PATH = "/soap";
    public static final String BASE_URL = "http://" + HOST + ":" + PORT + SERVER_SOAP_PATH;
}
