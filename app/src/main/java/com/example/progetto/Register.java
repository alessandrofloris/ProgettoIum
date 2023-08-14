package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Register extends AppCompatActivity {

    TextInputEditText username, password, confirmPassword, cittaDiProvenienza;
    TextInputEditText data;
    TextInputLayout usernameInputLayout, passwordInputLayout, confirmPasswordLayout, cittaDiProvenienzaLayout, dataLayout;
    Button conferma;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.sign_username);
        password=findViewById(R.id.sign_password);
        confirmPassword=findViewById(R.id.sign_confirm_password);
        cittaDiProvenienza=findViewById(R.id.sign_citta);
        data=findViewById(R.id.sign_data);
        conferma=findViewById(R.id.sign_conferma);

        usernameInputLayout = findViewById(R.id.sign_username_layout);
        passwordInputLayout = findViewById(R.id.sign_password_layout);
        confirmPasswordLayout = findViewById(R.id.sign_confirm_password_layout);
        cittaDiProvenienzaLayout = findViewById(R.id.sign_citta_layout);
        dataLayout = findViewById(R.id.sign_data_layout);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Registrazione");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDialog();
                }
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()){
                    DataBase.addUtente(createUtente());
                    Intent goBackToLogIn= new Intent(Register.this, MainActivity.class);
                    startActivity(goBackToLogIn);
                }
            }
        });

        conferma.setEnabled(false);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                conferma.setEnabled(!username.getText().toString().equals("") && !password.getText().toString().equals("")
                        && !confirmPassword.getText().toString().equals("") && !cittaDiProvenienza.getText().toString().equals("")
                        && !data.getText().toString().equals(""));
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
                conferma.setEnabled(!username.getText().toString().equals("") && !password.getText().toString().equals("")
                        && !confirmPassword.getText().toString().equals("") && !cittaDiProvenienza.getText().toString().equals("")
                        && !data.getText().toString().equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                conferma.setEnabled(!username.getText().toString().equals("") && !password.getText().toString().equals("")
                        && !confirmPassword.getText().toString().equals("") && !cittaDiProvenienza.getText().toString().equals("")
                        && !data.getText().toString().equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cittaDiProvenienza.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                conferma.setEnabled(!username.getText().toString().equals("") && !password.getText().toString().equals("")
                        && !confirmPassword.getText().toString().equals("") && !cittaDiProvenienza.getText().toString().equals("")
                        && !data.getText().toString().equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        data.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                conferma.setEnabled(!username.getText().toString().equals("") && !password.getText().toString().equals("")
                        && !confirmPassword.getText().toString().equals("") && !cittaDiProvenienza.getText().toString().equals("")
                        && !data.getText().toString().equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public boolean checkInput(){
        int errori=0;
        if(username.getText().length()==0){
            usernameInputLayout.setError("Inserire un nome");
            errori++;
        }else if(DataBase.cercaUtenteUsername(username.getText().toString())){
            usernameInputLayout.setError("Lo Username inserito è già utilizzato");
            errori++;
        }else usernameInputLayout.setError(null);

        if(!password.getText().toString().equals(confirmPassword.getText().toString())){
            passwordInputLayout.setError("Le password non corrispondono");
            confirmPasswordLayout.setError("Le password non corrispondono");
            errori++;
        }else{
            passwordInputLayout.setError(null);
            confirmPasswordLayout.setError(null);
        }

        if(password.getText().length()==0){
            passwordInputLayout.setError("Inserire una password");
            errori++;
        }

        if(confirmPassword.getText().length()==0){
            confirmPasswordLayout.setError("Confermare la password");
            errori++;
        }

        if(cittaDiProvenienza.getText().length()==0){
            cittaDiProvenienzaLayout.setError("Inserire la città di provenienza");
            errori++;
        }else cittaDiProvenienzaLayout.setError(null);
        if(data.getText().length()==0){
            dataLayout.setError("Inserire una data");
            errori++;
        }else dataLayout.setError(null);

        return  errori==0;
    }

    Utente createUtente(){
        return new Utente(username.getText().toString(), password.getText().toString(), cittaDiProvenienza.getText().toString(), data.getText().toString());
    }

    void showDialog() {
        DialogFragment newFragment = DatePickerFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick(Calendar date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        data.setText(format.format(date.getTime()));
    }

    public void doNegativeClick() {

    }
}