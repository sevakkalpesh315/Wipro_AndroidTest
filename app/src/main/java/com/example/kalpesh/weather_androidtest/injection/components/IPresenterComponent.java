package com.example.kalpesh.weather_androidtest.injection.components;

import com.example.kalpesh.weather_androidtest.WeatherList;
import com.example.kalpesh.weather_androidtest.injection.netmodule.Presenter_Module;

import dagger.Component;

/**
 * Created by kalpesh on 14/08/2017.
 */

@PerActivity
@Component(dependencies = {Presenter_Module.class})
public interface IPresenterComponent {

    void inject(WeatherList weatherList);

}
