package com.example.kalpesh.weather_androidtest.fivedays_weather;
/**
 * Created by kalpesh on 14/08/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kalpesh.weather_androidtest.R;
import com.example.kalpesh.weather_androidtest.model.WeatherData;

/**
 * A ViewHolder which is an item view of an element of the weather forecast's list
 */
public class Weather_FiveDays_ViewHolder extends RecyclerView.ViewHolder {

    /**
     * Current view
     */
    public final View mView;
    /**
     * Image view where will be inflated the image of the weather
     */
    public final ImageView mImageWeather;
    /**
     * Text view where will be inflated the time
     */
    public final TextView mTime;

    /**
     * Text view where will be inflated the temperature
     */
    public final TextView mTemperature;

    /**
     * Text view where will be inflated the wind
     */
    public final TextView mWind;

    /**
     * Text view where will be inflated the pressure
     */
    public final TextView mPressure;

    /**
     * All the data of a Country
     */
    public WeatherData mWeatherData;

    /**
     * Constructor of the class
     * It will initialize variables of this class
     * @param view view to be hold
     */
    public Weather_FiveDays_ViewHolder(View view) {
        super(view);
        //Initialize view to be hold
        mView = view;
        //Get weather image view
        mImageWeather = (ImageView) view.findViewById(R.id.weather_data_image);
        //Get time text view
        mTime = (TextView) view.findViewById(R.id.weather_data_time);
        //Get temperature text view
        mTemperature = (TextView) view.findViewById(R.id.weather_data_temperature);
        //Get pressure text view
        mPressure = (TextView) view.findViewById(R.id.weather_data_pressure);
        //Get wind text view
        mWind = (TextView) view.findViewById(R.id.weather_data_wind);
    }

}
