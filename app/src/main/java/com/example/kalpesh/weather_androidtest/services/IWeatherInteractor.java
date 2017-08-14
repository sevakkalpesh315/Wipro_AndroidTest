package com.example.kalpesh.weather_androidtest.services;

import com.example.kalpesh.weather_androidtest.injection.components.APIComponent;
import com.example.kalpesh.weather_androidtest.model.WeatherResponse;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 14/08/2017.
 */

public interface IWeatherInteractor {
    public void initiateInjectionGraph(APIComponent apiComponent);

    Observable<WeatherResponse> get5DaysWeatherList();
}
