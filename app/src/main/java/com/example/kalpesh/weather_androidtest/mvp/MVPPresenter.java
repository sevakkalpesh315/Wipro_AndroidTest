package com.example.kalpesh.weather_androidtest.mvp;

/**
 * Created by kalpesh on 14/08/2017.
 */

public interface MVPPresenter<V extends MVPView> {
    void attachView(V mvpview);
    void detachView();
}
