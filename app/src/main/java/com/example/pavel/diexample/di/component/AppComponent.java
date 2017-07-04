package com.example.pavel.diexample.di.component;


import android.content.Context;

import com.example.pavel.diexample.api.ApiInterface;
import com.example.pavel.diexample.data.WeatherRepository;
import com.example.pavel.diexample.di.model.AppModule;
import com.example.pavel.diexample.di.model.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RetrofitModule.class})
@Singleton
public interface AppComponent {

    void inject(WeatherRepository repository);

    Context getContext();

    ApiInterface endpointInterface();

}
