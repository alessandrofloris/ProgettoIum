package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourthStepRegistration extends AppCompatActivity {

    ImageView previous_activity_button;
    Button continue_button;
    ChipGroup regions_chip_group;
    List<Locations> all_regions;
    int selected_regions;
    RegistrationBean registration_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_step_registration);

        backButtonConfig();
        getRegistrationData();
        regionsListInizialization();
        chipGroupConfig();
        continueButtonConfig();
    }

    private void getRegistrationData() {
        registration_data = (RegistrationBean) getIntent().getSerializableExtra("registration_data_3");
    }

    private void regionsListInizialization() {
        all_regions = new ArrayList<>();
        all_regions.addAll(Arrays.asList(Locations.values()));
        all_regions.remove(all_regions.size()-1);
    }

    private void chipGroupConfig() {
        regions_chip_group = findViewById(R.id.regions_chip_group);

        selected_regions = 0;

        Chip chip;
        for(Locations region : all_regions) {
            chip = new Chip(this);
            chip.setId(ViewCompat.generateViewId());
            chip.setText(region.getDesc());
            chip.setCheckable(true);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                    Chip c = (Chip) compoundButton;
                    if(checked) {
                        if (selected_regions >= 3) {
                            c.setChecked(false);
                            Toast.makeText(getApplicationContext(), "Attenzione, puoi aggiungere massimo 3 regioni!", Toast.LENGTH_SHORT).show();

                        } else {
                            selected_regions = selected_regions + 1;
                        }
                    } else {
                        selected_regions = selected_regions - 1;
                    }
                }
            });
            regions_chip_group.addView(chip);
        }

    }

    private void continueButtonConfig() {
        continue_button = findViewById(R.id.continue_button);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chip c;
                List<String> selected_locations = new ArrayList<>();
                List<Integer> selected_chips = regions_chip_group.getCheckedChipIds();
                for(Integer location : selected_chips) {
                    c = (Chip) findViewById(location);
                    selected_locations.add(c.getText().toString());
                }
                registration_data.setLocations(selected_locations);
                Intent intent = new Intent(FourthStepRegistration.this, FifthStepRegistration.class);
                intent.putExtra("registration_data_4", (Serializable) registration_data);
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