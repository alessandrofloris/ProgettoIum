package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    public Button log_in;
    public TextView sign_up_link;
    public TextInputEditText username, password;
    public TextInputLayout usernameInputLayout, passwordInputLayout;

    @Override
    protected void onResume() {
        super.onResume();
        password.setText("");
        usernameInputLayout.setError(null);
        passwordInputLayout.setError(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        DataBase.addUtente(new Utente("admin", "admin", "Cagliari", "13/10/1999"));

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        log_in = findViewById(R.id.log_in);
        sign_up_link = findViewById(R.id.sign_up_link);
        usernameInputLayout = findViewById(R.id.text_iput_layout_username);
        passwordInputLayout = findViewById(R.id.text_iput_layout_password);

        sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUp = new Intent(MainActivity.this, FirstStepRegistration.class);
                startActivity(goToSignUp);
            }
        });

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkLogIn()) {
                    DataBase.utenteLoggato = username.getText().toString();
                    Intent log_in_succesfull = new Intent(MainActivity.this, Home.class);
                    startActivity(log_in_succesfull);
                }
            }
        });

        log_in.setEnabled(false);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                log_in.setEnabled(!username.getText().toString().equals("") && !password.getText().toString().equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                log_in.setEnabled(!username.getText().toString().equals("") && !password.getText().toString().equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    boolean checkLogIn() {
        int errori = DataBase.confermaDatiLogIn(username.getText().toString(), password.getText().toString());

        if (errori != 0) {
            switch (errori) {
                case 1:
                    if (password.getText().toString().length() == 0)
                        passwordInputLayout.setError("Inserire una password");
                    else passwordInputLayout.setError("Password errata");
                    errori++;
                    break;
                case 2:
                    usernameInputLayout.setError("Username non esistente");
                    passwordInputLayout.setError("Password non valida");
            }
        } else {
            usernameInputLayout.setError(null);
            passwordInputLayout.setError(null);
        }


        return errori > 0;
    }
}