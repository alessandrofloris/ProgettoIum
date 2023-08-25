package com.example.progetto;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectGenreActivity extends AppCompatActivity {

    RecyclerView genres_list_recyclerview;
    ChipAdapter adapter;
    Integer chips_checked_counter;
    Map<Genres, Boolean> chips_checked;
    Button apply_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_genre);

        toolbarConfig();

        chipsConfig();

        applyButtonConfig();

    }

    private void applyButtonConfig() {
        apply_button = findViewById(R.id.apply_changes);
        apply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Genres> selectedGenres = new ArrayList<>();
                for(Map.Entry<Genres, Boolean> entry : chips_checked.entrySet()) {
                    if(entry.getValue()) {
                        selectedGenres.add(entry.getKey());
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("selected_genres", (Serializable) selectedGenres);
                setResult(10, intent);
                finish();
            }
        });
    }

    private void chipsConfig() {

        this.chips_checked_counter = 0;
        this.chips_checked = new HashMap<>();

        genres_list_recyclerview = findViewById(R.id.genres_recyclerview);

        ArrayList<String> genres = new ArrayList<>();
        ArrayList<FiltersInterface> genres_id = new ArrayList<>();

        for(Genres genre: Genres.values()) {
            genres.add(genre.getDesc());
            genres_id.add(genre);
        }
        genres.remove(genres.size()-1); // rimuovo l'enum "NONE"
        genres_id.remove(genres_id.size()-1);

        adapter = new ChipAdapter(genres, genres_id, new ChipAdapter.OnChipClickListener() {
            @Override public void onChipClick(Chip chip) {

                if(chip.isChecked()) {
                    if(chips_checked_counter >= 3) {
                        chip.setChecked(false);
                    } else {
                        chips_checked.put((Genres) chip.getTag(), true);
                        chips_checked_counter = chips_checked_counter + 1;
                    }
                } else {
                    chips_checked.put((Genres) chip.getTag(), false);
                    chips_checked_counter = chips_checked_counter - 1;
                }
            }
        });
        genres_list_recyclerview.setAdapter(adapter);
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