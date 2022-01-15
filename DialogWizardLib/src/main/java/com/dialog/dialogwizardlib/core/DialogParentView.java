package com.dialog.dialogwizardlib.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.dialog.dialogwizardlib.databinding.DialogwizardlibParentBinding;


public class DialogParentView extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        com.dialog.dialogwizardlib.databinding.DialogwizardlibParentBinding __binder = DialogwizardlibParentBinding.inflate(inflater);
        return __binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // this second container is needed in order to NOT have empty background while
        // switching fragments
        WizardContainer mContainer = new WizardContainer(this);
        mContainer.show(requireActivity().getSupportFragmentManager(),"dialogwizardlib_container");

    }
}
