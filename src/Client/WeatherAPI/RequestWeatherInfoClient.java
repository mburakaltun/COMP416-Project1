package Client.WeatherAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestWeatherInfoClient {
    private Socket client;
    private BufferedReader clientIn;
    private BufferedReader keyboard;
    private PrintWriter clientOut;

    public RequestWeatherInfoClient(Socket client, BufferedReader clientIn, BufferedReader keyboard, PrintWriter clientOut) {
        this.client = client;
        this.clientIn = clientIn;
        this.clientOut = clientOut;
        this.keyboard = keyboard;
    }

    public void run() throws IOException {
        cityResponse();
        while (!client.isClosed()) {
            requestWeatherInfo();
        }
    }

    public void cityResponse() throws IOException {
        System.out.println(clientIn.readLine());
        String cityName = keyboard.readLine();
        clientOut.println(cityName);

        String message;
        String response;
        if ((message = clientIn.readLine()) != null) {
            System.out.println(message);
        }
        if ((response = clientIn.readLine()) != null) {
            System.out.println(response);
            if (response.compareTo("False") == 0) {
                client.close();
            }
        }
    }

    public void requestWeatherInfo() throws IOException {
        System.out.println(clientIn.readLine());
        String request = keyboard.readLine();
        clientOut.println(request);

        String response = clientIn.readLine();
        String message = clientIn.readLine();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(message.toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);

        if (response.compareTo("False") == 0) {
            client.close();
        }

    }

}
