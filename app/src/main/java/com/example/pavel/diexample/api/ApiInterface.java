package com.example.pavel.diexample.api;

import com.example.pavel.diexample.data.Day;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("weather/{user_id}")
    Call<List<Day>> getWeather(@Path(value = "user_id", encoded = true) String city);
}
