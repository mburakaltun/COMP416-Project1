package Server.WeatherInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("lat")
    @Expose
    public Float lat;
    @SerializedName("lon")
    @Expose
    public Float lon;
    @SerializedName("timezone")
    @Expose
    public String timezone;
    @SerializedName("timezone_offset")
    @Expose
    public Integer timezoneOffset;
    @SerializedName("current")
    @Expose
    public Current current;
    @SerializedName("minutely")
    @Expose
    public List<Minutely> minutely = null;
    @SerializedName("hourly")
    @Expose
    public List<Hourly> hourly = null;

    public Float getLat() {
        return lat;
    }

    public Float getLon() {
        return lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public Current getCurrent() {
        return current;
    }

    public List<Minutely> getMinutely() {
        return minutely;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    @SerializedName("daily")
    @Expose
    public List<Daily> daily = null;
}