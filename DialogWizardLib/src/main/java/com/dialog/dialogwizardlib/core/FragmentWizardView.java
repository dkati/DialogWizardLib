package com.dialog.dialogwizardlib.core;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dialog.dialogwizardlib.R;
import com.dialog.dialogwizardlib.interfaces.FragmentStateListener;
import com.dialog.dialogwizardlib.interfaces.WizardExitListener;

@SuppressWarnings({"Convert2Lambda"})
public class FragmentWizardView extends Fragment {

    private FragmentStateListener mFragmentListener;
    private WizardExitListener exitListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentListener = (FragmentStateListener) context;
        exitListener = (WizardExitListener) context;
    }

    protected void saveCurrentViewState(View v) {
        int which = Integer.parseInt(String.valueOf(v.getTag()));
        mFragmentListener.onFragmentViewSaveNow(v,which);
    }

    private void exitWizard() {
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

        View.OnClickListener exiter = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitWizard();
            }
        };

        if ( v == null ) {
            if (view.findViewById(R.id.fab_wizard_exit) == null)
                crashWithException();
            else
                view.findViewById(R.id.fab_wizard_exit).setOnClickListener(exiter);
        } else {
            if (v.findViewById(R.id.fab_wizard_exit) == null)
                crashWithException();
            else
                v.findViewById(R.id.fab_wizard_exit).setOnClickListener(exiter);
        }

        // if the saved view is null (never initialized),use the binder's inflated view
        // keep in mind that loader has to be cleared on Wizard exit
        return v == null ? view : v ;
    }

    private void crashWithException(){
        throw new RuntimeException("Every wizard page must have a clickable element with android:id=\"@+id/fab_wizard_exit\" ");
    }

}