package com.example.kalpesh.weather_androidtest;

import com.example.kalpesh.weather_androidtest.fivedays_weather.WeatherListPresenter_Impl;
import com.example.kalpesh.weather_androidtest.model.WeatherResponse;
import com.example.kalpesh.weather_androidtest.mvp.BasePresenter;
import com.example.kalpesh.weather_androidtest.mvp.IWeatherListContract;
import com.example.kalpesh.weather_androidtest.services.RequestInterface;
import com.example.kalpesh.weather_androidtest.services.WeatherInteractor_Impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;

import io.reactivex.Observable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by kalpesh on 13/08/2017.
 */

public class WeatherListPresenterTest {

    @Mock
    @Inject
    RequestInterface apiInterface;

    @Mock
    IWeatherListContract.IWeatherListView mockView;

    @Mock
    WeatherInteractor_Impl interactor;//repository

    @Mock
    WeatherResponse weatherResponse;

    @InjectMocks
    WeatherListPresenter_Impl mockPresenter;
    /**
     * Initialize mocks
     * @throws Exception
     */

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        weatherResponse = new WeatherResponse();
        mockView = mock(IWeatherListContract.IWeatherListView.class);
        mockPresenter = new WeatherListPresenter_Impl(interactor);
    }

    @Test
    public void testDataShouldLoadIntotheView() {

        when(interactor.get5DaysWeatherList())
                .thenReturn(Observable.just(weatherResponse));
        mockPresenter.attachView(mockView);
        InOrder inOrder= Mockito.inOrder(mockView);
        inOrder.verify(mockView, times(1)).onFetchDataStarted();
        inOrder.verify(mockView, times(1)).onFetchDataSuccess(weatherResponse);
        inOrder.verify(mockView, times(1)).onFetchDataCompleted();
    }

    @Test
    public void noInteractionsWithViewShouldTakePlaceIfUserIsNull() {
        // user object is not initialized, lets verify no interactions take place
        verifyZeroInteractions(mockView);
    }

    @Test
    public void fetchErrorShouldReturnErrorToView() {

        Exception exception = new Exception();
        when(interactor.get5DaysWeatherList())
                .thenReturn(Observable.just(weatherResponse));
        mockPresenter.attachView(mockView);
        InOrder inOrder = Mockito.inOrder(mockView);
        inOrder.verify(mockView, times(1)).onFetchDataStarted();
        inOrder.verify(mockView, times(1)).onFetchDataError(exception);
        verify(mockView, never()).onFetchDataCompleted();
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException.class)
    public void search_NotAttached_ThrowsMvpException() {
        mockPresenter.detachView();
        mockPresenter.getFiveDaysWeather();
        verify(mockView, never()).onFetchDataStarted();
    }

}
