package com.example.kalpesh.weather_androidtest.injection.netmodule;

import com.example.kalpesh.weather_androidtest.services.WeatherInteractor_Impl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kalpesh on 14/08/2017.
 */

@Module
public class Presenter_Module {

    @Provides
    public WeatherInteractor_Impl getInteractor(){
        return new WeatherInteractor_Impl();
    }
}
