package Server.WeatherAPI;

import Server.WeatherInfo.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.ArrayList;

public class WeatherService {

    private static final String APIKey = "0d4f408c4e2354392d1398f53e0f7c66";
    private Socket client;
    private BufferedReader serverIn;
    private PrintWriter serverOut;
    private ArrayList<City> cities = new ArrayList<>();
    private ArrayList<String> requests = new ArrayList<String>();

    public WeatherService(Socket client, BufferedReader serverIn, PrintWriter serverOut) {
        this.client = client;
        this.serverIn = serverIn;
        this.serverOut = serverOut;

        CustomCityCreator customCityCreator = new CustomCityCreator();
        customCityCreator.initialize();
        cities = customCityCreator.getCityList();

        requests.add("1");
        requests.add("2");
        requests.add("3");
        requests.add("4");
    }

    public void execute() throws IOException, InterruptedException {
        City city = checkCity();
        System.out.println(city.getName());
        boolean connected = true;
        while (city != null && connected) {
            SendWeatherInfo(city);
        }
    }

    public City checkCity() throws IOException {
        serverOut.println("Enter your city, please choose on of the followings; Istanbul, Samsun, Eskisehir, Ankara, Malatya, Bursa, Izmir): ");
        String cityName = serverIn.readLine();

        for (City currentCity : cities) {
            if (cityName.compareTo(currentCity.getName()) == 0) {
                serverOut.println("The city name is valid.");
                serverOut.println("True");
                return currentCity;
            }
        }
        serverOut.println("The city name is invalid. You have been disconnected!");
        serverOut.println("False");
        serverIn.close();
        serverOut.close();
        client.close();
        return null;
    }

    private boolean SendWeatherInfo(City city) throws IOException, InterruptedException {
        serverOut.println("Enter the number associated with weather request, " +
                "type \"1\" for Current Weather Forecast" +
                "type \"2\" for Daily forecast for 7 days" +
                "type \"3\" for Hourly Weather Forecast" +
                "type \"4\" for Minute forecast for 1 hour" +
                "type \"quit\" in order to quit:");

        String request = serverIn.readLine();
        if (!requests.contains(request)) {
            serverOut.println("False");
            serverOut.println("Invalid request. You have been disconnected!");
            return false;
        } else if (request.compareTo("quit") == 0) {
            serverOut.println("False");
            serverOut.println("You have been disconnected! Good bye!");
            return false;
        } else {
            serverOut.println("True");
            String weatherInfo = APICall(city, request);
            serverOut.println(weatherInfo);
            return true;
        }
    }

    public String APICall(City city, String weatherRequest) throws IOException, InterruptedException {
        String callUri = "";
        if(weatherRequest.compareTo("1") == 0) {
             callUri = "https://api.openweathermap.org/data/2.5/onecall?" + "lat=" + city.getLat() + "&lon=" + city.getLon() + "&exclude=hourly,alerts,minutely,daily"
                    + "&appid=" + APIKey + "";
        } else if(weatherRequest.compareTo("2") == 0) {
            callUri = "https://api.openweathermap.org/data/2.5/onecall?" + "lat=" + city.getLat() + "&lon=" + city.getLon() + "&exclude=hourly,alerts,minutely,current"
                    + "&appid=" + APIKey + "";
        } else if(weatherRequest.compareTo("3") == 0) {
            callUri = "https://api.openweathermap.org/data/2.5/onecall?" + "lat=" + city.getLat() + "&lon=" + city.getLon() + "&exclude=daily,alerts,minutely,current"
                    + "&appid=" + APIKey + "";
        } else if(weatherRequest.compareTo("4") == 0) {
            callUri = "https://api.openweathermap.org/data/2.5/onecall?" + "lat=" + city.getLat() + "&lon=" + city.getLon() + "&exclude=daily,alerts,hourly,current"
                    + "&appid=" + APIKey + "";
        } else {
            callUri = "https://api.openweathermap.org/data/2.5/onecall?" + "lat=" + city.getLat() + "&lon=" + city.getLon() + "&exclude="
                    + "&appid=" + APIKey + "";
        }

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(callUri)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        return response.body().toString();

    }

}
