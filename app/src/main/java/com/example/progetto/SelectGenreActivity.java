package com.example.progetto;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectGenreActivity extends AppCompatActivity {

    RecyclerView genres_list_view;
    ChipAdapter adapter;
    List<Genres> selectedGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_genre);

        toolbarConfig();

        chipsConfig();

        selectedGenres = new ArrayList<>();

    }

    private void chipsConfig() {
        genres_list_view = findViewById(R.id.genres_list);

        ArrayList<String> genres = new ArrayList<>();

        for(Genres genre: Genres.values()) {
            genres.add(genre.getDesc());
        }
        genres.remove(genres.size()-1); // rimuovo l'enum "NONE"

        adapter = new ChipAdapter(genres, new ChipAdapter.OnChipClickListener() {
            @Override public void onChipClick(String item) {
                Toast.makeText(SelectGenreActivity.this, "Item Clicked", Toast.LENGTH_LONG).show();

            }
        });
        genres_list_view.setAdapter(adapter);
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