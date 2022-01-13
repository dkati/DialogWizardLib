package com.dialogwizardlib.lib;

import androidx.appcompat.app.AppCompatActivity;

import com.dialogwizardlib.lib.libcore.DialogParentView;

public class DialogWizard {

    private final DialogParentView mParent;
    private final AppCompatActivity mActivity;

    public DialogWizard(AppCompatActivity activity) {
        mParent = new DialogParentView();
        mActivity = activity;
    }

    public void show() {
        mParent.show(mActivity.getSupportFragmentManager(),"dialogwizardlib");
    }
}
