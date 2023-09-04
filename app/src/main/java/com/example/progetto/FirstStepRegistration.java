package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

public class FirstStepRegistration extends AppCompatActivity {

    ImageView previous_activity_button;
    Button continue_button;
    TextInputEditText name_input, surname_input;
    boolean name_input_fill, surname_input_fill;

    RegistrationBean registration_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_step_registration);

        registration_data = new RegistrationBean();

        backButtonConfig();
        inputsConfig();
        continueButtonConfig();
    }

    private void inputsConfig() {
        name_input = findViewById(R.id.name_input);
        surname_input = findViewById(R.id.surname_input);

        name_input_fill = false;
        surname_input_fill = false;

        nameInputSetListener();
        surnameInputSetListener();

    }

    private void nameInputSetListener() {
        name_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(name_input.getText().toString().equals("")) {
                    name_input_fill = false;
                } else {
                    name_input_fill = true;
                }

                updateContinueButtonStatus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void surnameInputSetListener() {
        surname_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(surname_input.getText().toString().equals("")) {
                    surname_input_fill = false;
                } else {
                    surname_input_fill = true;
                }

                updateContinueButtonStatus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void updateContinueButtonStatus() {
        if(name_input_fill && surname_input_fill) {
            continue_button.setEnabled(true);
        } else {
            continue_button.setEnabled(false);
        }

    }

    private void continueButtonConfig() {
        continue_button = findViewById(R.id.continue_button);
        continue_button.setEnabled(false);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registration_data.setName(name_input.getText().toString());
                registration_data.setSurname(surname_input.getText().toString());

                Intent intent = new Intent(FirstStepRegistration.this, SecondStepRegistration.class);
                intent.putExtra("registration_data_1", (Serializable) registration_data);
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