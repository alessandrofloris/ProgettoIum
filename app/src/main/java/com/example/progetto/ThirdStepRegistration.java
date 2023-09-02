package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdStepRegistration extends AppCompatActivity {

    ImageView previous_activity_button;
    Button continue_button;
    ChipGroup genres_chip_group;
    List<Genres> all_genres;
    int selected_genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_step_registration);

        backButtonConfig();
        genresListInizialization();
        chipGroupConfig();
        continueButtonConfig();
    }

    private void genresListInizialization() {
        all_genres = new ArrayList<>();
        all_genres.addAll(Arrays.asList(Genres.values()));
        all_genres.remove(all_genres.size()-1);
    }

    private void chipGroupConfig() {
        genres_chip_group = findViewById(R.id.genres_chip_group);

        selected_genres = 0;

        Chip chip;
        for(Genres genre : all_genres) {
            chip = new Chip(this);
            chip.setId(ViewCompat.generateViewId());
            chip.setText(genre.getDesc());
            chip.setCheckable(true);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                    Chip c = (Chip) compoundButton;
                    if(checked) {
                        if (selected_genres >= 3) {
                            c.setChecked(false);
                            Toast.makeText(getApplicationContext(), "Attenzione, puoi aggiungere massimo 3 generi!", Toast.LENGTH_SHORT).show();

                        } else {
                            selected_genres = selected_genres + 1;
                        }
                    } else {
                        selected_genres = selected_genres - 1;
                    }
                }
            });
            genres_chip_group.addView(chip);
        }

    }

    private void continueButtonConfig() {
        continue_button = findViewById(R.id.continue_button);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdStepRegistration.this, FourthStepRegistration.class);
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