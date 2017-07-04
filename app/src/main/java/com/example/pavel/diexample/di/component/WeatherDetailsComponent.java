package com.example.pavel.diexample.di.component;

import com.example.pavel.diexample.di.model.WeatherDetailsModel;
import com.example.pavel.diexample.di.scope.WeatherDetailsScope;
import com.example.pavel.diexample.ui.weather.WeatherDetailsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {WeatherDetailsModel.class})
@WeatherDetailsScope
public interface WeatherDetailsComponent {

    void inject(WeatherDetailsFragment fragment);
}
