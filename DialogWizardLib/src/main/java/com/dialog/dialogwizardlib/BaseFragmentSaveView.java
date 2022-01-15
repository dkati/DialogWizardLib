package com.dialog.dialogwizardlib;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dialog.dialogwizardlib.interfaces.FragmentStateListener;
import com.dialog.dialogwizardlib.interfaces.WizardExitListener;

public class BaseFragmentSaveView extends Fragment {

    private FragmentStateListener mFragmentListener;
    private WizardExitListener exitListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentListener = (FragmentStateListener) context;
        exitListener = (WizardExitListener) context;
    }

    protected void saveCurrentViewState(View v,int which) {
        mFragmentListener.onFragmentViewSaveNow(v,which);
    }

    protected void exitWizard() {
        exitListener.onExit();

        Fragment f = requireActivity().getSupportFragmentManager().findFragmentByTag("dialogwizardlib_container");
        if (f != null)
            requireActivity().getSupportFragmentManager().beginTransaction().remove(f).commitNowAllowingStateLoss();
        else
            Log.e("BaseFragmentSaveView", "Could not find parent dialog");
    }

    protected View onCreateSavedView(View view,int which) {
        // get the saved view from loaded (regardless if its null or not)
        View v = mFragmentListener.onFragmentViewLoadNow(which);

        // if the saved view is null (never initialized),use the binder's inflated view
        // keep in mind that loader has to be cleared on Wizard exit
        return v == null ? view : v ;
    }

}