package com.dialog.dialogwizardlib.wizardlayouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.dialog.dialogwizardlib.R;
import com.dialog.dialogwizardlib.core.FragmentWizardView;
import com.dialog.dialogwizardlib.databinding.FragmentThirdBinding;

@SuppressWarnings({"Convert2Lambda"})
public class ThirdFragment extends FragmentWizardView {

    private FragmentThirdBinding binding;
    private View mThisView;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        mThisView = super.onCreateSavedView(binding.getRoot());
        return mThisView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // save the state when we change fragment
                saveCurrentViewState(mThisView);

                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_SecondFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}