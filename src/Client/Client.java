package Client;

import Client.Authentication.AuthenticationClient;
import Client.WeatherAPI.RequestWeatherInfoClient;

import java.io.*;
import java.net.*;

public class Client {

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", PORT);
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);
        
        AuthenticationClient authenticationClient = new AuthenticationClient(client, clientIn, clientOut, keyboard);
        authenticationClient.run();
        RequestWeatherInfoClient requestWeatherInfoClient = new RequestWeatherInfoClient(client, clientIn, keyboard, clientOut);
        requestWeatherInfoClient.run();
    }

}
