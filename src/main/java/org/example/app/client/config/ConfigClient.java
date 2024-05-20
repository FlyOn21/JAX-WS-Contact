package org.example.app.client.config;

public class ConfigClient {
    public final static String SERVER_HOST = "localhost";
    public final static int SERVER_PORT = 8189;
    public final static String SERVER_SOAP_PATH = "/soap";
    public final static String WSDL_URL = "http://" + SERVER_HOST + ":" + SERVER_PORT + SERVER_SOAP_PATH;
    public final static String SERVICE_IMPL = "SOAPServerService";
    public final static String SERVICE_URI = "http://services.server.app.example.org/";
}
