package com.example.kalpesh.weather_androidtest.mvp;

import com.example.kalpesh.weather_androidtest.model.WeatherResponse;

/**
 * Created by kalpesh on 14/08/2017.
 */

public interface IWeatherListContract {

    public interface IWeatherListView extends MVPView{
        void onFetchDataStarted();
        void onFetchDataError(Throwable e);
        void onFetchDataCompleted();
        void onFetchDataSuccess(WeatherResponse weatherResponse);

    }

    public interface IWeatherListPresenter extends MVPPresenter<IWeatherListView>{

        void getFiveDaysWeather();

    }
}
