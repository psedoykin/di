package com.example.pavel.diexample.data;

import com.example.pavel.diexample.App;
import com.example.pavel.diexample.api.Api;
import com.example.pavel.diexample.utils.LocationUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    public interface OnWeatherListener {
        void onLoaded(List<Day> list);

        void onError();
    }

    private volatile static WeatherRepository mInstance;
    private List<Day> mDayList;

    public static synchronized WeatherRepository getInstance() {
        if (mInstance == null) {
            mInstance = new WeatherRepository();
        }
        return mInstance;
    }


    public Day getDayWeather(int id){
        Day day = null;
        if(mDayList != null && mDayList.size() > id){
            day = mDayList.get(id);
        }
        return day;
    }

    public void getWeather(final OnWeatherListener listener) {

        String city = LocationUtils.getCity(App.getAppContext());

        Api.getApiService().getWeather(city).enqueue(new Callback<List<Day>>() {
            @Override
            public void onResponse(Call<List<Day>> call, Response<List<Day>> response) {
                if (response.isSuccessful()) {
                    mDayList = response.body();
                    if (listener != null) {
                        listener.onLoaded(mDayList);
                    }
                } else {
                    if (listener != null) {
                        listener.onError();
                    }
                }
            }


            @Override
            public void onFailure(Call<List<Day>> call, Throwable t) {
                if (listener != null) {
                    listener.onError();
                }
            }
        });
    }

}


