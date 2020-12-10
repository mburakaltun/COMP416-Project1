package Server.WeatherInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Daily {

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
    public Temp temp;
    @SerializedName("feels_like")
    @Expose
    public FeelsLike feelsLike;
    @SerializedName("pressure")
    @Expose
    public Integer pressure;
    @SerializedName("humidity")
    @Expose
    public Integer humidity;
    @SerializedName("dew_point")
    @Expose
    public Float dewPoint;
    @SerializedName("wind_speed")
    @Expose
    public Float windSpeed;
    @SerializedName("wind_deg")
    @Expose
    public Integer windDeg;
    @SerializedName("clouds")
    @Expose
    public Integer clouds;
    @SerializedName("pop")
    @Expose
    public Integer pop;
    @SerializedName("uvi")
    @Expose
    public Float uvi;
    @SerializedName("rain")
    @Expose
    public Integer rain;

    public Integer getDt() {
        return dt;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public Temp getTemp() {
        return temp;
    }

    public FeelsLike getFeelsLike() {
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

    public Float getWindSpeed() {
        return windSpeed;
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public Integer getClouds() {
        return clouds;
    }

    public Integer getPop() {
        return pop;
    }

    public Float getUvi() {
        return uvi;
    }

    public Integer getRain() {
        return rain;
    }
}