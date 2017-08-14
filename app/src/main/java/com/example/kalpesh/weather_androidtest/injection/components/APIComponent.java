package com.example.kalpesh.weather_androidtest.injection.components;


import com.example.kalpesh.weather_androidtest.injection.netmodule.APIModule;
import com.example.kalpesh.weather_androidtest.services.WeatherInteractor_Impl;

import dagger.Component;

/**
 * Created by kalpesh on 14/08/2017.
 */
@PerActivity
@Component(dependencies = NetComponent.class, modules = APIModule.class)
public interface APIComponent {
    void inject(WeatherInteractor_Impl movieList_interactor);
}
