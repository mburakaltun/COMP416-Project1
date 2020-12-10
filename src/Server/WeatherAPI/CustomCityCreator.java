package Server.WeatherAPI;

import Server.Authentication.User;

import java.util.ArrayList;

public class CustomCityCreator {

    ArrayList<City> cityList = new ArrayList<City>();

    public CustomCityCreator() {

    }

    public void initialize() {
        String name1 = "Istanbul";
        String lat1 = "41.01384";
        String lon1 = "28.949659";
        City Istanbul = new City(name1, lat1, lon1);

        String name2 = "Samsun";
        String lat2 = "36.330002";
        String lon2 = "41.286671";
        City Samsun = new City(name2, lat2, lon2);

        String name3 = "Eskisehir";
        String lat3 = "31.16667";
        String lon3 = "39.666672";
        City Eskisehir = new City(name3, lat3, lon3);

        String name4 = "Ankara";
        String lat4 = "32.833328";
        String lon4 = "39.916672";
        City Ankara = new City(name4, lat4, lon4);

        String name5 = "Malatya";
        String lat5 = "38.0";
        String lon5 = "38.5";
        City Malatya = new City(name5, lat5, lon5);

        String name6 = "Bursa";
        String lat6 = "29.08333";
        String lon6 = "40.166672";
        City Bursa = new City(name6, lat6, lon6);

        String name7 = "Izmir";
        String lat7 = "27.092291";
        String lon7 = "38.462189";
        City Izmir = new City(name7, lat7, lon7);

        cityList.add(Istanbul);
        cityList.add(Samsun);
        cityList.add(Eskisehir);
        cityList.add(Ankara);
        cityList.add(Malatya);
        cityList.add(Bursa);
        cityList.add(Izmir);
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }
}
