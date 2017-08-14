package com.example.kalpesh.weather_androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WeatherMain {


    @SerializedName("temp")
    @Expose
    private String temp;

    @SerializedName("pressure")
    @Expose
    private String pressure;

    public WeatherMain(String temp, String pressure) {
        this.temp = temp;
        this.pressure = pressure;
    }

    public String getTemp() {
        return temp;
    }

    public String getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "WeatherMain{" +
                "temp='" + temp + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
