package com.dialogwizardlib.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.dialog.dialogwizardlib.DialogWizard;
import com.dialog.dialogwizardlib.core.BaseActivityFragmentLoader;
import com.dialogwizardlib.databinding.ActivityMainBinding;

@SuppressWarnings({"Convert2Lambda"})
public class MainActivity extends BaseActivityFragmentLoader {
    // MainActivity (host activity) needs to extends our loader

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        _WizardInitPages(3);
        DialogWizard wizard = new DialogWizard(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wizard.show();
            }
        });
    }


}