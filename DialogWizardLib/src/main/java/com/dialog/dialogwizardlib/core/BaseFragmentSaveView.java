package com.dialog.dialogwizardlib.core;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.dialog.dialogwizardlib.R;
import com.dialog.dialogwizardlib.interfaces.OnFragmentViewLoadListener;
import com.dialog.dialogwizardlib.interfaces.OnFragmentViewSaveListener;

public class BaseFragmentSaveView extends Fragment {

    private OnFragmentViewLoadListener viewLoaderListener;
    private OnFragmentViewSaveListener viewSaveListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewSaveListener = (OnFragmentViewSaveListener) context;
        viewLoaderListener = (OnFragmentViewLoadListener) context;
    }

    protected void saveCurrentViewState(View v) {
        viewSaveListener.onFragmentViewSaveNow(v);
    }

    protected void exitWizard() {
        viewSaveListener.onFragmentViewSaveNow(null);

        //NavHostFragment x  = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);

    }

    protected View onCreateSavedView(View view) {
        // get the saved view from loaded (regardless if its null or not)
        View v = viewLoaderListener.onFragmentViewLoadNow();

        // if the saved view is null (never initialized),use the binder's inflated view
        // keep in mind that loader has to be cleared on Wizard exit
        return v == null ? view : v ;
    }

}