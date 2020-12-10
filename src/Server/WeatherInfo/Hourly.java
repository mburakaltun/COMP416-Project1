package Server.WeatherInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hourly {

    @SerializedName("dt")
    @Expose
    public Integer dt;
    @SerializedName("temp")
    @Expose
    public Float temp;
    @SerializedName("feels_like")
    @Expose
    public Float feelsLike;
    @SerializedName("pressure")
    @Expose
    public Integer pressure;
    @SerializedName("humidity")
    @Expose
    public Integer humidity;
    @SerializedName("dew_point")
    @Expose
    public Float dewPoint;
    @SerializedName("clouds")
    @Expose
    public Integer clouds;
    @SerializedName("visibility")
    @Expose
    public Integer visibility;
    @SerializedName("wind_speed")
    @Expose
    public Float windSpeed;
    @SerializedName("wind_deg")
    @Expose
    public Integer windDeg;
    @SerializedName("pop")
    @Expose
    public Integer pop;
    @SerializedName("rain")
    @Expose
    public Rain rain;

    public Integer getDt() {
        return dt;
    }

    public Float getTemp() {
        return temp;
    }

    public Float getFeelsLike() {
        return feelsLike;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Float getDewPoint() {
        return dewPoint;
    }

    public Integer getClouds() {
        return clouds;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public Integer getPop() {
        return pop;
    }

    public Rain getRain() {
        return rain;
    }
}