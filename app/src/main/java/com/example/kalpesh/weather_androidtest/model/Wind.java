package com.example.kalpesh.weather_androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kalpesh on 14/08/2017.
 */
public class Wind {

    @SerializedName("speed")
    @Expose
    private String speed;

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed='" + speed + '\'' +
                '}';
    }
}
