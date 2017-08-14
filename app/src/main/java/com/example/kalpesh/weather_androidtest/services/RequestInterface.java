package com.example.kalpesh.weather_androidtest.services;

import com.example.kalpesh.weather_androidtest.model.WeatherResponse;
import com.example.kalpesh.weather_androidtest.model.api_list.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by kalpesh on 14/08/2017.
 */

public interface RequestInterface {
    @GET(Constants.API_WEATHER_5_DAYS + Constants.WEATHER_API_KEY)
    Observable<WeatherResponse> getWeather5DaysForecast();
}
