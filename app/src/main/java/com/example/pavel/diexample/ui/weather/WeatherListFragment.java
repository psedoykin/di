package com.example.pavel.diexample.ui.weather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pavel.diexample.R;
import com.example.pavel.diexample.data.Day;
import com.example.pavel.diexample.data.WeatherRepository;
import com.example.pavel.diexample.ui.base.BaseFragment;
import com.example.pavel.diexample.ui.base.BaseRecycleAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherListFragment extends BaseFragment {

    public final static String TAG = WeatherListFragment.class.getSimpleName();

    public static WeatherListFragment newInstance() {
        return new WeatherListFragment();
    }

    private DayAdapter mAdapter;

    @BindView(R.id.list) RecyclerView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_list, container, false);
        ButterKnife.bind(this, view);

        mAdapter = new DayAdapter();
        mListView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mListView.setLayoutManager(layoutManager);

        mAdapter.setOnItemClickListener(new BaseRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showFragment(WeatherDetailsFragment.newInstance(position), WeatherDetailsFragment.TAG);
            }
        });

        updateWeather();
        return view;
    }

    private void updateWeather(){
        WeatherRepository.getInstance().getWeather(new WeatherRepository.OnWeatherListener() {
            @Override
            public void onLoaded(List<Day> list) {
                mAdapter.setItems(list);
            }

            @Override
            public void onError() {
                //todo
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.weather_title));
        }
    }
}
