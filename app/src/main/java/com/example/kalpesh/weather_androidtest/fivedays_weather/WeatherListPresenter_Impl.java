package com.example.kalpesh.weather_androidtest.fivedays_weather;

import android.util.Log;

import com.example.kalpesh.weather_androidtest.injection.components.APIComponent;
import com.example.kalpesh.weather_androidtest.model.WeatherResponse;
import com.example.kalpesh.weather_androidtest.mvp.BasePresenter;
import com.example.kalpesh.weather_androidtest.mvp.IWeatherListContract;
import com.example.kalpesh.weather_androidtest.services.WeatherInteractor_Impl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kalpesh on 14/08/2017.
 */
public class WeatherListPresenter_Impl extends BasePresenter<IWeatherListContract.IWeatherListView> implements IWeatherListContract.IWeatherListPresenter{

    private WeatherInteractor_Impl weatherInteractor_;

    @Inject
    public WeatherListPresenter_Impl(WeatherInteractor_Impl weatherInteractor_) {
        this.weatherInteractor_ = weatherInteractor_;
    }

    @Override
    public void attachView(IWeatherListContract.IWeatherListView mvpView) {
        super.attachView(mvpView);
    }

    public void injectForData(APIComponent apiComponent) {
        weatherInteractor_.initiateInjectionGraph(apiComponent);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    /**
     * Interacts with the API to get the weather list for 5 days
     */
    @Override
    public void getFiveDaysWeather() {
        checkViewAttached();
        getView().onFetchDataStarted();
        weatherInteractor_.get5DaysWeatherList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( this::onSuccess, this::onError);
    }

    private void onSuccess(WeatherResponse weatherResponse) {
        getView().onFetchDataSuccess(weatherResponse);

        if(weatherResponse.getCod().equals("200")) {
            Log.i("Weather", ""+weatherResponse.getList().get(1).getWind());
        }
        else{

        }
    }
    private void onError(Throwable throwable) {
        getView().onFetchDataError(throwable);
    }
}
