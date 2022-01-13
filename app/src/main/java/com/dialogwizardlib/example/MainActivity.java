package com.dialogwizardlib.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.dialog.dialogwizardlib.DialogWizard;
import com.dialogwizardlib.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DialogWizard wizard = new DialogWizard(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wizard.show();
            }
        });
    }


}