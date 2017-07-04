package com.example.pavel.diexample.di.model;


import com.example.pavel.diexample.data.WeatherRepository;
import com.example.pavel.diexample.di.scope.WeatherScope;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModel {

    @Provides
    @WeatherScope
    WeatherRepository provideWeatherRepository() {
        return new WeatherRepository();
    }
}
