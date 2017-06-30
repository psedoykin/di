package com.example.pavel.diexample.ui.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.pavel.diexample.R;


public abstract class BaseFragment extends Fragment {


    private void hiddenKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        Activity activity = getActivity();
        if (activity != null) {
            View view = activity.getCurrentFocus();
            if (view != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static void showKeyboard(Context context) {
        ((InputMethodManager) (context).getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }


    protected void showFragment(Fragment fragment, String TAG) {
        FragmentManager manager = getFragmentManager();
        if (manager != null) {
            manager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(TAG).commit();
        }
    }

    protected void showFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        if (manager != null) {
            manager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        hiddenKeyboard();
    }
}
