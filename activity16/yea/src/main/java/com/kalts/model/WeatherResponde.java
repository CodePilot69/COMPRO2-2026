package com.weather.app.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("dataseries")
    public List<Forecast> forecasts;
}

class Forecast {
    public int timepoint;
    
    @SerializedName("temp2m")
    public int temperature;

    @SerializedName("wind10m")
    public Wind wind;
}

class Wind {
    public String direction;
    public int speed;
}