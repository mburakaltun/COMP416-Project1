package Server.WeatherInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp {

    @SerializedName("day")
    @Expose
    public Float day;
    @SerializedName("min")
    @Expose
    public Float min;
    @SerializedName("max")
    @Expose
    public Float max;
    @SerializedName("night")
    @Expose
    public Float night;
    @SerializedName("eve")
    @Expose
    public Float eve;
    @SerializedName("morn")
    @Expose
    public Float morn;

    public Float getDay() {
        return day;
    }

    public Float getMin() {
        return min;
    }

    public Float getMax() {
        return max;
    }

    public Float getNight() {
        return night;
    }

    public Float getEve() {
        return eve;
    }

    public Float getMorn() {
        return morn;
    }
}