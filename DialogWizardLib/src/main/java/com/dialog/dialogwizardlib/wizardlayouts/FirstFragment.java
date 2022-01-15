package com.dialog.dialogwizardlib.wizardlayouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.dialog.dialogwizardlib.R;
import com.dialog.dialogwizardlib.core.FragmentWizardView;
import com.dialog.dialogwizardlib.databinding.FragmentFirstBinding;

@SuppressWarnings({"Convert2Lambda"})
public class FirstFragment extends FragmentWizardView {

    private FragmentFirstBinding binding;
    private View mThisView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        mThisView = super.onCreateSavedView(binding.getRoot());
        return mThisView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo: A better appoach like...nextpage() previouspage() ?
                // save of the instance happens inside->
                changePage(mThisView,FirstFragment.this,R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}