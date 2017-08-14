package com.example.kalpesh.weather_androidtest.fivedays_weather;
/**
 * Created by kalpesh on 14/08/2017.
 */
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalpesh.weather_androidtest.R;
import com.example.kalpesh.weather_androidtest.model.Weather;
import com.example.kalpesh.weather_androidtest.model.WeatherData;
import com.example.kalpesh.weather_androidtest.model.api_list.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A Recyler View Adapter which inflate into a recycler view a given list of weather forecast
 */
public class Weather_FiveDays_RecyclerViewAdapter
        extends RecyclerView.Adapter<Weather_FiveDays_ViewHolder> {

    /**
     * List of weather forecast
     */
    private final ArrayList<WeatherData> mWeatherDataList;
    /**
     * Context of the activity which created this object
     */
    private Context mContext;

    /**
     * Constructor of the class
     * It will initialize variables of this class
     * @param mWeatherDataList list of weather forecast
     * @param mContext Context of the activity which created this object
     */
    public Weather_FiveDays_RecyclerViewAdapter(ArrayList<WeatherData> mWeatherDataList, Context mContext) {
        //Init weather forecast list
        this.mWeatherDataList = mWeatherDataList;
        //Init main context
        this.mContext = mContext;
    }

    /**
     * Called when the view holder is created.
     * Initialize countries view holder
     * @param parent parent view
     * @param viewType type view
     * @return Initialized Countries View Holder
     */
    @Override
    public Weather_FiveDays_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_weather_list, parent, false);
        return new Weather_FiveDays_ViewHolder(view);
    }

    /**
     * Called when the view holder is bind
     * It will inflate all the data to the view holder
     * @param holder view holder to be inflate
     * @param position position in the list
     */
    @Override
    public void onBindViewHolder(final Weather_FiveDays_ViewHolder holder, int position) {
        //Set countries data into the holder
        holder.mWeatherData = mWeatherDataList.get(position);

        //Show weather image
        ArrayList<Weather> mWeatherList = holder.mWeatherData.getWeather();
        if (mWeatherList != null && mWeatherList.get(0).getIcon() != null) {

            String mWeatherIcon = mWeatherList.get(0).getIcon().toLowerCase();
            //Set picasso library to show the weather image

            Picasso.Builder builder = new Picasso.Builder(mContext );
            builder.listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    exception.printStackTrace();
                }
            });
            builder.build()
                    .load(Constants.URL_IMG_WEATHER + mWeatherIcon + Constants.EXT_WEATHER)
                    .error(android.R.drawable.ic_menu_close_clear_cancel)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.mImageWeather);

        }

        //Set time
        holder.mTime.setText(holder.mWeatherData.getTime());

        //Set Wind
        holder.mWind.setText(holder.mWeatherData.getWind().getSpeed()+" m/s");

        //Set Pressure
        holder.mPressure.setText(holder.mWeatherData.getMain().getPressure());

        //Set temperature
        holder.mTemperature.setText(holder.mWeatherData.getMain().getTemp()+" F");

    }

    /**
     * Get number of countries
     * @return number of countries
     */
    @Override
    public int getItemCount() {
        return mWeatherDataList.size();
    }


}
