package com.example.pavel.diexample.di.component;


import com.example.pavel.diexample.di.model.WeatherDetailsModel;
import com.example.pavel.diexample.di.model.WeatherModel;
import com.example.pavel.diexample.di.scope.WeatherScope;
import com.example.pavel.diexample.ui.weather.WeatherListFragment;

import dagger.Subcomponent;


@Subcomponent(modules = {WeatherModel.class})
@WeatherScope
public interface WeatherComponent {

    void inject(WeatherListFragment fragment);

    WeatherDetailsComponent plusWeatherDetailsComponent(WeatherDetailsModel model);

}
