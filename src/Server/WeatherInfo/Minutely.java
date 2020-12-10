package Server.WeatherInfo;

import java.util.HashMap;
import java.util.Map;

public class Minutely {

    private Integer dt;
    private Integer precipitation;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Integer precipitation) {
        this.precipitation = precipitation;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Minutely{" +
                "dt=" + dt +
                ", precipitation=" + precipitation +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}