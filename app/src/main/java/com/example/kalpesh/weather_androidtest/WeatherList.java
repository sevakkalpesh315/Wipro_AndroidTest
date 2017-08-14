package com.example.kalpesh.weather_androidtest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kalpesh.weather_androidtest.fivedays_weather.WeatherListPresenter_Impl;
import com.example.kalpesh.weather_androidtest.fivedays_weather.Weather_FiveDays_RecyclerViewAdapter;
import com.example.kalpesh.weather_androidtest.injection.components.APIComponent;
import com.example.kalpesh.weather_androidtest.model.WeatherResponse;
import com.example.kalpesh.weather_androidtest.mvp.IWeatherListContract;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by kalpesh on 14/08/2017.
 */
public class WeatherList extends Fragment implements IWeatherListContract.IWeatherListView{

    private ProgressDialog progressDialog;
    private RecyclerView recycler_weather_list;
    private ArrayList fiveDaysWeatherList;
    // private WeatherInteractor_Impl weatherInteractor;
    @Inject
    WeatherListPresenter_Impl weatherPresenter;

    public WeatherList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WeatherList.
     */
    public static WeatherList newInstance() {
        return new WeatherList();
    }

    /**
     * Inflate the UI components
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        InitializeDagger();
        setInjections();
        return inflater.inflate(R.layout.fragment_weather_list, container, false);
    }

    /**
     * Used to initialize my UI components
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler_weather_list=(RecyclerView)view.findViewById(R.id.recycler_weather_list);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        weatherPresenter.attachView(this);
        weatherPresenter.getFiveDaysWeather();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        weatherPresenter.detachView();
    }

    public void InitializeDagger(){
        ((MyWeatherApp)getActivity().getApplication()).getiPresenterComponent().inject(this);
    }

    @Inject
    public void setWeatherPresenter(WeatherListPresenter_Impl weatherPresenter){
        this.weatherPresenter= weatherPresenter;
    }
    private void setInjections() {
        APIComponent apiComponent = ((MyWeatherApp)getActivity().getApplication()).getApiComponent();
        weatherPresenter.injectForData(apiComponent);
    }

    /**
       Implemented Methods
     */

    @Override
    public void onFetchDataStarted() {
        progressDialog= new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.loadMsg));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    public void onFetchDataError(Throwable e) {
        dismissProgressView();
        Toast.makeText(getActivity().getApplicationContext(),"Network problem",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFetchDataCompleted() {
        dismissProgressView();

    }
    private void dismissProgressView(){
        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }
    @Override
    public void onFetchDataSuccess(WeatherResponse weatherResponse) {
        dismissProgressView();
        //Inflate recycler view with the list of  weather forecast
        recycler_weather_list.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),3));
        recycler_weather_list.setAdapter(new Weather_FiveDays_RecyclerViewAdapter(weatherResponse.getList(), getActivity()));
    }


}
