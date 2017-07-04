package com.example.pavel.diexample.di.model;


import android.content.Context;

import com.example.pavel.diexample.di.scope.WeatherDetailsScope;
import com.example.pavel.diexample.utils.AnimationHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherDetailsModel {

    @Provides
    @WeatherDetailsScope
    AnimationHelper provideAnimationHelper(Context context) {
        return new AnimationHelper(context);
    }
}
