package com.dialog.dialogwizardlib.core;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.dialog.dialogwizardlib.interfaces.OnFragmentViewLoadListener;
import com.dialog.dialogwizardlib.interfaces.OnFragmentViewSaveListener;

@SuppressLint("Registered") // This activity is just a wrapper. No need to be registered to Manifest
public class BaseActivityFragmentLoader extends AppCompatActivity implements OnFragmentViewSaveListener, OnFragmentViewLoadListener {

    private View mFragmentLayout;

    @Override
    public void onFragmentViewSaveNow(View data) {
        mFragmentLayout = data;
    }

    @Override
    public View onFragmentViewLoadNow() {
        return mFragmentLayout;
    }

}
