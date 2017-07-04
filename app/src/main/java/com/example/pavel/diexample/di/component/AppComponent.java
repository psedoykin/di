package com.example.pavel.diexample.di.component;


import com.example.pavel.diexample.data.WeatherRepository;
import com.example.pavel.diexample.di.model.AppModule;
import com.example.pavel.diexample.di.model.RetrofitModule;
import com.example.pavel.diexample.di.model.SettingsModel;
import com.example.pavel.diexample.di.model.WeatherModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RetrofitModule.class})
@Singleton
public interface AppComponent {

    void inject(WeatherRepository repository);


    WeatherComponent plusWeatherComponent(WeatherModel model);

    SettingsComponent plusSettingsComponent(SettingsModel model);

}
