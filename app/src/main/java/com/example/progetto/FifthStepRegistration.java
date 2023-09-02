package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FifthStepRegistration extends AppCompatActivity {

    ImageView previous_activity_button;
    Button continue_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_step_registration);

        backButtonConfig();
        continueButtonConfig();

    }

    private void continueButtonConfig() {
        continue_button = findViewById(R.id.continue_button);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthStepRegistration.this, Home.class);
                startActivity(intent);
            }
        });
    }

    private void backButtonConfig() {
        previous_activity_button = findViewById(R.id.previous_activity_button);

        previous_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}