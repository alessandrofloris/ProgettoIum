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

public class SecondStepRegistration extends AppCompatActivity {

    ImageView previous_activity_button;
    Button continue_button;
    TextInputEditText username_input, email_input, password_input, password_confirm_input;
    boolean username_input_fill, email_input_fill, password_input_fill, password_confirm_input_fill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step_registration);

        backButtonConfig();
        inputsConfig();
        continueButtonConfig();
    }

    private void inputsConfig() {
        username_input = findViewById(R.id.username_input);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        password_confirm_input = findViewById(R.id.password_confirm_input);

        username_input_fill = false;
        email_input_fill = false;
        password_input_fill = false;
        password_confirm_input_fill = false;

        usernameInputSetListener();
        emailInputSetListener();
        passwordInputSetListener();
        passwordConfirmInputSetListener();

    }

    private void usernameInputSetListener() {
        username_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(username_input.getText().toString().equals("")) {
                    username_input_fill = false;
                } else {
                    username_input_fill = true;
                }

                updateContinueButtonStatus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void emailInputSetListener() {
        email_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(email_input.getText().toString().equals("")) {
                    email_input_fill = false;
                } else {
                    email_input_fill = true;
                }

                updateContinueButtonStatus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void passwordInputSetListener() {
        password_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(password_input.getText().toString().equals("")) {
                    password_input_fill = false;
                } else {
                    password_input_fill = true;
                }

                updateContinueButtonStatus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void passwordConfirmInputSetListener() {
        password_confirm_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(password_confirm_input.getText().toString().equals("")) {
                    password_confirm_input_fill = false;
                } else {
                    password_confirm_input_fill = true;
                }

                updateContinueButtonStatus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void updateContinueButtonStatus() {
        if(username_input_fill && email_input_fill && password_input_fill && password_confirm_input_fill) {
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
                Intent intent = new Intent(SecondStepRegistration.this, ThirdStepRegistration.class);
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