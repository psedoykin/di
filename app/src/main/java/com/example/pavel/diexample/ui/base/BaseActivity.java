package com.example.pavel.diexample.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.pavel.diexample.R;


public abstract class BaseActivity extends AppCompatActivity {

    protected FragmentManager mFragmentManager;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void showFragment(Fragment fragment, String TAG) {

        if (mFragmentManager == null) {
            mFragmentManager = getSupportFragmentManager();
        }
        mFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(TAG).commit();
    }

    protected void showFragment(Fragment fragment) {

        if (mFragmentManager == null) {
            mFragmentManager = getSupportFragmentManager();
        }
        mFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
    }
}
