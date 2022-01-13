package com.dialogwizardlib.lib;

import androidx.appcompat.app.AppCompatActivity;

import com.dialogwizardlib.lib.wizardlayouts.DialogParentView;

public class DialogWizard {

    private final DialogParentView mParent;
    private AppCompatActivity mActivity;

    public DialogWizard(AppCompatActivity activity) {
        mParent = new DialogParentView();
        mActivity = activity;
    }

    public void show(){
        mParent.show(mActivity.getSupportFragmentManager(),"dialogwizardlib");
    }
}
