package com.example.pavel.diexample.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.pavel.diexample.R;
import com.example.pavel.diexample.ui.base.BaseActivity;
import com.example.pavel.diexample.ui.settings.SettingsFragment;
import com.example.pavel.diexample.ui.weather.WeatherListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.nav_view) NavigationView mNavigationView;

    private ActionBarDrawerToggle mToggle;
    private View.OnClickListener mOriginalToolbarListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

        };

        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mOriginalToolbarListener = mToggle.getToolbarNavigationClickListener();
        mNavigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            showFragment(WeatherListFragment.newInstance());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_weather:
                showFragment(WeatherListFragment.newInstance());
                break;
            case R.id.nav_settings:
                showFragment(SettingsFragment.newInstance());
                break;
        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
