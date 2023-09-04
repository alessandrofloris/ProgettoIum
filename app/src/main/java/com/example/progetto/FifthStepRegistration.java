package com.example.progetto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class FifthStepRegistration extends AppCompatActivity {

    ImageView previous_activity_button;
    Button continue_button;
    TextView name_text, surname_text, username_text, email_text;
    ChipGroup genres_chip_group, regions_chip_group;
    RegistrationBean registration_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_step_registration);

        toolbarConfig();
        getRegistrationData();
        inputsConfigInitialization();
        continueButtonConfig();

    }

    private void toolbarConfig() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void inputsConfigInitialization() {
        name_text = findViewById(R.id.name_text);
        surname_text = findViewById(R.id.surname_text);
        username_text = findViewById(R.id.username_text);
        email_text = findViewById(R.id.email_text);
        genres_chip_group = findViewById(R.id.genres_chip_group);
        regions_chip_group = findViewById(R.id.regions_chip_group);

        name_text.setText(registration_data.getName());
        surname_text.setText(registration_data.getSurname());
        username_text.setText(registration_data.getUsername());
        email_text.setText(registration_data.getEmail());

        Chip chip;
        for(String genre : registration_data.getGenres()) {
            chip = new Chip(this);
            chip.setId(ViewCompat.generateViewId());
            chip.setText(genre);
            genres_chip_group.addView(chip);
        }

        for(String location : registration_data.getLocations()) {
            chip = new Chip(this);
            chip.setId(ViewCompat.generateViewId());
            chip.setText(location);
            regions_chip_group.addView(chip);
        }

    }

    private void getRegistrationData() {
        registration_data = (RegistrationBean) getIntent().getSerializableExtra("registration_data_4");
    }

    private void continueButtonConfig() {
        continue_button = findViewById(R.id.continue_button);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthStepRegistration.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}