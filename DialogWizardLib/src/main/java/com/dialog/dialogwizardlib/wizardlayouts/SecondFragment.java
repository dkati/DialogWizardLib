package com.dialog.dialogwizardlib.wizardlayouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.dialog.dialogwizardlib.R;
import com.dialog.dialogwizardlib.core.BaseFragmentSaveView;
import com.dialog.dialogwizardlib.databinding.FragmentSecondBinding;

@SuppressWarnings({"Convert2Lambda"})
public class SecondFragment extends BaseFragmentSaveView {

    private FragmentSecondBinding binding;
    private View mThisView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        mThisView = super.onCreateSavedView(binding.getRoot(),1);
        return mThisView;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecondPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // save the state when we change fragment
                saveCurrentViewState(mThisView,1);

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.buttonSecondNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // save the state when we change fragment
                saveCurrentViewState(mThisView,1);

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitWizard();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}