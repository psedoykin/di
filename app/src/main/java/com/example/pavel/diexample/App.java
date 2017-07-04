package com.example.pavel.diexample;

import android.app.Application;
import android.content.Context;

import com.example.pavel.diexample.di.component.AppComponent;
import com.example.pavel.diexample.di.component.DaggerAppComponent;
import com.example.pavel.diexample.di.component.SettingsComponent;
import com.example.pavel.diexample.di.component.WeatherComponent;
import com.example.pavel.diexample.di.component.WeatherDetailsComponent;
import com.example.pavel.diexample.di.model.AppModule;
import com.example.pavel.diexample.di.model.RetrofitModule;
import com.example.pavel.diexample.di.model.SettingsModel;
import com.example.pavel.diexample.di.model.WeatherDetailsModel;
import com.example.pavel.diexample.di.model.WeatherModel;

public class App extends Application {

    private static App mInstance;
    private AppComponent mAppComponent;
    private WeatherComponent mWeatherComponent;
    private WeatherDetailsComponent mWeatherDetailsComponent;
    private SettingsComponent mSettingsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public App() {
        mInstance = this;

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(mInstance))
                .retrofitModule(new RetrofitModule())
                .build();

    }

    public static App get() {
        return mInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public WeatherComponent plusWeatherComponent() {
        if (mWeatherComponent == null) {
            mWeatherComponent = mAppComponent.plusWeatherComponent(new WeatherModel());
        }
        return mWeatherComponent;
    }

    public void clearWeatherComponent() {
        mWeatherComponent = null;
    }

    public WeatherDetailsComponent plusWeatherDetailsComponent() {
        if (mWeatherDetailsComponent == null) {
            mWeatherDetailsComponent = mWeatherComponent.plusWeatherDetailsComponent(new WeatherDetailsModel());
        }
        return mWeatherDetailsComponent;
    }

    public void clearWeatherDetailsComponent() {
        mWeatherDetailsComponent = null;
    }

    public SettingsComponent plusSettingsComponent() {
        if (mSettingsComponent == null) {
            mSettingsComponent = mAppComponent.plusSettingsComponent(new SettingsModel());
        }
        return mSettingsComponent;
    }

    public void clearSettingsComponent() {
        mSettingsComponent = null;
    }


    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }
}
