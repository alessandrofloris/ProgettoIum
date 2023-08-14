package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoMusicMatch extends AppCompatActivity {

    Button indietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_music_match);

        indietro = findViewById(R.id.back_to_signup);

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUp = new Intent(InfoMusicMatch.this, FirstStepRegistration.class);
                startActivity(goToSignUp);
            }
        });


    }
}