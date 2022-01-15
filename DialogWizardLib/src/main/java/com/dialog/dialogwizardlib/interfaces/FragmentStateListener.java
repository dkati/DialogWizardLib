package com.dialog.dialogwizardlib.interfaces;

import android.view.View;

public interface FragmentStateListener {
    void onFragmentViewSaveNow(View data, int which);
    View onFragmentViewLoadNow(int which);
}
