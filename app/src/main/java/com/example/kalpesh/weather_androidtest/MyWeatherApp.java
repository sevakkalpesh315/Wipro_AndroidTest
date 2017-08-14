package com.example.kalpesh.weather_androidtest;

import android.app.Application;
import android.content.Context;

import com.example.kalpesh.weather_androidtest.injection.components.APIComponent;
import com.example.kalpesh.weather_androidtest.injection.components.DaggerAPIComponent;
import com.example.kalpesh.weather_androidtest.injection.components.DaggerIPresenterComponent;
import com.example.kalpesh.weather_androidtest.injection.components.DaggerNetComponent;
import com.example.kalpesh.weather_androidtest.injection.components.IPresenterComponent;
import com.example.kalpesh.weather_androidtest.injection.components.NetComponent;
import com.example.kalpesh.weather_androidtest.injection.netmodule.APIModule;
import com.example.kalpesh.weather_androidtest.injection.netmodule.AppModule;
import com.example.kalpesh.weather_androidtest.injection.netmodule.NetModule;
import com.example.kalpesh.weather_androidtest.model.api_list.Constants;

/**
 * Created by kalpesh on 14/08/2017.
 */

public class MyWeatherApp extends Application{
    private IPresenterComponent iPresenterComponent;
    private NetComponent netComponent;
    private APIComponent apiComponent;
    public static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }


    public IPresenterComponent getiPresenterComponent() {
        return iPresenterComponent;
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public APIComponent getApiComponent() {
        return apiComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;


        iPresenterComponent= DaggerIPresenterComponent.create();
        netComponent= DaggerNetComponent.builder()
                .netModule(new NetModule(Constants.API_WEATHER))
                .appModule(new AppModule(this))
                .build();

        apiComponent= DaggerAPIComponent.builder()
                .netComponent(netComponent)
                .aPIModule(new APIModule())
                .build();

    }
}
