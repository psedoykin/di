package com.example.pavel.diexample.ui.weather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pavel.diexample.App;
import com.example.pavel.diexample.R;
import com.example.pavel.diexample.data.Day;
import com.example.pavel.diexample.data.WeatherRepository;
import com.example.pavel.diexample.utils.AnimationHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDetailsFragment extends Fragment {


    public final static String TAG = WeatherDetailsFragment.class.getSimpleName();

    private static final String ARGUMENT_ID = "argument_id";

    @Inject
    public WeatherRepository mRepository;

    @Inject
    public AnimationHelper mHelper;

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
        App.get().plusWeatherDetailsComponent().inject(this);

        int id = getArguments().getInt(ARGUMENT_ID);
        Day day = mRepository.getDayWeather(id);
        if (day != null) {
            mDayDate.setText(day.mDate);
            mTemperature.setText(day.mTemp);
        }

        mHelper.showAnimation(view);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.weather_details_title));
        }
    }

}
