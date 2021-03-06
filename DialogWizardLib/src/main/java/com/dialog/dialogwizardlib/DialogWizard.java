package com.dialog.dialogwizardlib;

import androidx.appcompat.app.AppCompatActivity;

import com.dialog.dialogwizardlib.core.DialogParentView;

public class DialogWizard {

    private final DialogParentView mParent;
    private final AppCompatActivity mActivity;

    public DialogWizard(AppCompatActivity activity) {
        mParent = new DialogParentView();
        mActivity = activity;
    }

    public void show() {
        mParent.show(mActivity.getSupportFragmentManager(),"dialogwizardlib_parent");
    }
}
