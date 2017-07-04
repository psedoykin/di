package com.example.pavel.diexample.di.component;


import android.content.Context;

import com.example.pavel.diexample.data.WeatherRepository;
import com.example.pavel.diexample.di.model.WeatherModel;
import com.example.pavel.diexample.di.scope.WeatherScope;
import com.example.pavel.diexample.ui.weather.WeatherListFragment;

import dagger.Component;


@Component(dependencies = AppComponent.class, modules = {WeatherModel.class})
@WeatherScope
public interface WeatherComponent {

    void inject(WeatherListFragment fragment);

    //todo: ?
    Context context();

    WeatherRepository weatherRepository();

}
