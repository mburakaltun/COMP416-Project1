package Server.WeatherInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("1h")
    @Expose
    public Float _1h;

    public Float get_1h() {
        return _1h;
    }
}