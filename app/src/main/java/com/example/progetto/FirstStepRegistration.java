package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FirstStepRegistration extends AppCompatActivity {

    public Button sign_up_artist;
    public Button sign_up_producer;
    View infos;
    View previous_activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_step_registration);

        sign_up_artist = findViewById(R.id.artist_registration);
        sign_up_producer = findViewById(R.id.producer_registration);
        infos = findViewById(R.id.info);
        previous_activity_button = findViewById(R.id.previous_activity_button);

        previous_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(FirstStepRegistration.this, MainActivity.class);
                startActivity(goBack);
            }
        });

        sign_up_artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUp = new Intent(FirstStepRegistration.this, Register.class);
                startActivity(goToSignUp);
            }
        });

        sign_up_producer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUp = new Intent(FirstStepRegistration.this, Register.class);
                startActivity(goToSignUp);
            }
        });

        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSignUp = new Intent(FirstStepRegistration.this, InfoMusicMatch.class);
                startActivity(goToSignUp);
            }
        });


    }
}