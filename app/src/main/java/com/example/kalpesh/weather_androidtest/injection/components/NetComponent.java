package com.example.kalpesh.weather_androidtest.injection.components;


import com.example.kalpesh.weather_androidtest.injection.netmodule.AppModule;
import com.example.kalpesh.weather_androidtest.injection.netmodule.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by kalpesh on 14/08/2017.
 */
@Singleton
@Component(modules = {NetModule.class, AppModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
