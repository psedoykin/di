package com.example.pavel.diexample.ui.weather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pavel.diexample.App;
import com.example.pavel.diexample.R;
import com.example.pavel.diexample.data.Day;
import com.example.pavel.diexample.data.WeatherRepository;
import com.example.pavel.diexample.utils.AnimationHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDetailsFragment extends Fragment {


    public final static String TAG = WeatherDetailsFragment.class.getSimpleName();

    private static final String ARGUMENT_ID = "argument_id";


    public static WeatherDetailsFragment newInstance(int id) {
        WeatherDetailsFragment fragment = new WeatherDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGUMENT_ID, id);
        fragment.setArguments(bundle);
        return fragment;

    }

    @BindView(R.id.day_date) TextView mDayDate;
    @BindView(R.id.day_temperature) TextView mTemperature;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_details, container, false);
        ButterKnife.bind(this, view);
        AnimationHelper helper = new AnimationHelper();

        int id = getArguments().getInt(ARGUMENT_ID);

        Day day = WeatherRepository.getInstance().getDayWeather(id);
        if(day != null){
            mDayDate.setText(day.mDate);
            mTemperature.setText(day.mTemp);
        }

        helper.showAnimation(App.getAppContext(), view);
        ButterKnife.bind(this, view);
        return view;
    }

}
