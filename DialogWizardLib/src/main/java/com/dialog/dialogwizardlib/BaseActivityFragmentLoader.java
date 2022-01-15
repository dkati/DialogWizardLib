package com.dialog.dialogwizardlib;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.dialog.dialogwizardlib.interfaces.FragmentStateListener;
import com.dialog.dialogwizardlib.interfaces.WizardExitListener;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered") // This activity is just a wrapper. No need to be registered to Manifest
public class BaseActivityFragmentLoader extends AppCompatActivity implements FragmentStateListener, WizardExitListener {

    private List<View> mFragmentLayouts ;
    private int mCount;

    public void _WizardInitPages(int pages_count){
        mFragmentLayouts = new ArrayList<>();
        mCount = pages_count;
        for (int i=0;i<pages_count;i++)
            mFragmentLayouts.add(null);
    }

    @Override
    public void onFragmentViewSaveNow(View data,int which) {
        if (which == -1)
            mFragmentLayouts = new ArrayList<>();
        else
            mFragmentLayouts.set(which, data);
    }

    @Override
    public View onFragmentViewLoadNow(int which) {
        return mFragmentLayouts.get(which);
    }

    @Override
    public void onExit() {
        for (int i=0;i<mCount;i++)
            mFragmentLayouts.set(i,null);
    }
}
