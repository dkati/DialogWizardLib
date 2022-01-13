package com.dialogwizardlib.lib.libcore;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.dialogwizardlib.R;
import com.dialogwizardlib.databinding.DialogwizardlibWizardContainerBinding;
import com.dialogwizardlib.lib.Utils;

public class WizardContainer extends DialogFragment {


    private final DialogParentView mParentFragment;
    protected WizardContainer(DialogParentView parentfragment){
        mParentFragment = parentfragment;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            Utils.DisplayTools tools = new Utils.DisplayTools(requireActivity());
            int width = tools.getScreenRectangle().width();
            int height = tools.getScreenRectangle().height();

            if (dialog.getWindow() != null) {
                Window thisWindow = dialog.getWindow();
                thisWindow.setLayout(width, height);
                WindowManager.LayoutParams windowParams = thisWindow.getAttributes();
                windowParams.dimAmount = 0.0f;
                windowParams.windowAnimations = R.style.Theme_DialogWizardLibInternal;
                thisWindow.setAttributes(windowParams);
                thisWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                //add start end padding to the whole dialog
                thisWindow.getDecorView().setPadding(0, 0, 0, 0);

            } else {
                Log.e("DialogParentView", "Could not attach window");
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DialogwizardlibWizardContainerBinding __binder = DialogwizardlibWizardContainerBinding.inflate(inflater);
        return __binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.FirstFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mParentFragment.dismiss();
    }
}
