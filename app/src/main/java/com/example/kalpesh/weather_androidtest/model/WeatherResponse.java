package com.example.kalpesh.weather_androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
/**
 * Created by kalpesh on 14/08/2017.
 */
public class WeatherResponse
{

    @SerializedName("cod")
    @Expose
    private String cod;

    @SerializedName("list")
    @Expose
    private ArrayList<WeatherData> list;


    public String getCod() {
        return cod;
    }

    public ArrayList<WeatherData> getList() {
        return list;
    }



    @Override
    public String toString() {
        return "WeatherResponse{" +
                "cod='" + cod + '\'' +
                ", list=" + list +
                '}';
    }
}
