package com.example.progetto;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import com.google.android.material.chip.Chip;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectRegionActivity extends AppCompatActivity {

    RecyclerView regions_list_recyclerview;
    ChipAdapter adapter;
    Integer chips_checked_counter;
    Map<Locations, Boolean> chips_checked;
    Button apply_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);

        toolbarConfig();

        chipsConfig();

        applyButtonConfig();

    }

    private void handleAlreadySelectedLocations() {
        try {
            ArrayList<Locations> locations = (ArrayList<Locations>) getIntent().getSerializableExtra("selected_locations_search");
            Chip c;
            for(Locations location : locations) {
                c = regions_list_recyclerview.findViewWithTag(location);
                c.setChecked(true);
                chips_checked.put((Locations)c.getTag(), true);
                chips_checked_counter = chips_checked_counter + 1;
            }
        } catch(Exception e) {
            Log.d("RecyclerView Chip Err", e.getMessage());
        }
    }

    private void applyButtonConfig() {
        apply_button = findViewById(R.id.apply_changes);
        apply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Locations> selectedLocations = new ArrayList<>();
                for(Map.Entry<Locations, Boolean> entry : chips_checked.entrySet()) {
                    if(entry.getValue()) {
                        selectedLocations.add(entry.getKey());
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("selected_locations", (Serializable) selectedLocations);
                setResult(10, intent);
                finish();
            }
        });
    }

    private void chipsConfig() {

        this.chips_checked_counter = 0;
        this.chips_checked = new HashMap<>();

        regions_list_recyclerview = findViewById(R.id.regions_recyclerview);
        regions_list_recyclerview.getViewTreeObserver()
                .addOnGlobalLayoutListener(
                        new ViewTreeObserver.OnGlobalLayoutListener() {
                            @Override
                            public void onGlobalLayout() {
                                handleAlreadySelectedLocations();
                                regions_list_recyclerview.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                            }
                        });
        ArrayList<String> locations = new ArrayList<>();
        ArrayList<FiltersInterface> locations_id = new ArrayList<>();

        for(Locations location: Locations.values()) {
            locations.add(location.getDesc());
            locations_id.add(location);
        }
        locations.remove(locations.size()-1); // rimuovo l'enum "NONE"
        locations_id.remove(locations_id.size()-1);

        adapter = new ChipAdapter(locations, locations_id, new ChipAdapter.OnChipClickListener() {
            @Override public void onChipClick(Chip chip) {

                if(chip.isChecked()) {
                    if(chips_checked_counter >= 3) {
                        chip.setChecked(false);
                    } else {
                        chips_checked.put((Locations)chip.getTag(), true);
                        chips_checked_counter = chips_checked_counter + 1;
                    }
                } else {
                    chips_checked.put((Locations)chip.getTag(), false);
                    chips_checked_counter = chips_checked_counter - 1;
                }
            }
        });
        regions_list_recyclerview.setAdapter(adapter);
    }

    private void toolbarConfig() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.region_toolbar);

        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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