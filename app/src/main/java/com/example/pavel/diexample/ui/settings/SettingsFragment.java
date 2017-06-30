package com.example.pavel.diexample.ui.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pavel.diexample.App;
import com.example.pavel.diexample.R;
import com.example.pavel.diexample.utils.AnimationHelper;

public class SettingsFragment extends Fragment {

    public final static String TAG = SettingsFragment.class.getSimpleName();

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        AnimationHelper helper = new AnimationHelper();
        helper.showAnimation(App.getAppContext(), view);
        return view;
    }

}
