package com.example.kalpesh.weather_androidtest.injection.netmodule;

import com.example.kalpesh.weather_androidtest.MyWeatherApp;
import com.example.kalpesh.weather_androidtest.services.Offline_CacheData;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kalpesh on 14/08/2017.
 */
@Module
public class NetModule {
    String base_url;

    public NetModule(String base_url) {
        this.base_url = base_url;
    }


    @Singleton
    @Provides
    Gson provideGson() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        return gson;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(interceptor);
        // Enable response caching
        okHttpClient .addNetworkInterceptor(new Offline_CacheData.ResponseCacheInterceptor());
        okHttpClient .addInterceptor(new Offline_CacheData.OfflineResponseCacheInterceptor())
                // Set the cache location and size (5 MB)
                .cache(new Cache(new File(MyWeatherApp
                        .getContext().getCacheDir(),
                        "apiResponses"), 5 * 1024 * 1024));
        return okHttpClient.build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return restAdapter;

    }
}
