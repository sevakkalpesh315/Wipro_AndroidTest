package com.example.kalpesh.weather_androidtest.services;

import com.example.kalpesh.weather_androidtest.injection.components.APIComponent;
import com.example.kalpesh.weather_androidtest.model.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 14/08/2017.
 */

public class WeatherInteractor_Impl  implements IWeatherInteractor{

    @Inject
    RequestInterface requestInterface;
    public WeatherInteractor_Impl() {
    }
    /**
     * The Dagger graph injection is performed in the method.
     * @param apiComponent
     */
    @Override
    public void initiateInjectionGraph(APIComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    public Observable<WeatherResponse> get5DaysWeatherList() {
        return requestInterface.getWeather5DaysForecast();
    }
}
