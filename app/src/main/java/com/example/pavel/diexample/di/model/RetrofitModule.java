package com.example.pavel.diexample.di.model;

import com.example.pavel.diexample.api.Api;
import com.example.pavel.diexample.api.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public ApiInterface provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return Api.getRetrofit();
    }
}
