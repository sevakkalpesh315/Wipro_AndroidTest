package com.example.kalpesh.weather_androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
/**
 * Created by kalpesh on 14/08/2017.
 */
public class WeatherData {
    @SerializedName("main")
    @Expose
    private WeatherMain main;


    @SerializedName("weather")
    @Expose
    private ArrayList<Weather> weather;

    @SerializedName("wind")
    @Expose
    private Wind wind;


    @SerializedName("dt_txt")
    @Expose
    private String time;

    public WeatherData(Wind wind, String time) {
        this.wind = wind;
        this.time = time;
    }
    public WeatherMain getMain() {
        return main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "main=" + main +
                ", weather=" + weather +
                ", wind=" + wind +
                ", time=" + time +
                '}';
    }
}
