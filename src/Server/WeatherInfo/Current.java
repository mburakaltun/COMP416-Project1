package Server.WeatherInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("dt")
    @Expose
    public Integer dt;
    @SerializedName("sunrise")
    @Expose
    public Integer sunrise;
    @SerializedName("sunset")
    @Expose
    public Integer sunset;
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
    @SerializedName("uvi")
    @Expose
    public Float uvi;
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
    @SerializedName("weather")
    @Expose
    public List<Weather> weather = null;

    public Integer getDt() {
        return dt;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public Integer getSunset() {
        return sunset;
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

    public Float getUvi() {
        return uvi;
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

    public List<Weather> getWeather() {
        return weather;
    }
}