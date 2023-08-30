package com.example.progetto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Region;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Profile extends AppCompatActivity {

    List<Genres> genresList = new ArrayList<>();
    RecyclerView genresRecyclerView;
    RecyclerView regionsRecyclerView;
    List<Region> regionsList = new ArrayList<>();
    GenreTagAdapter genreTagAdapter;
    ImageButton addGenres;
    ImageButton addRegions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        genresRecyclerView = findViewById(R.id.producer_genres_recyclerView);
        addGenres = findViewById(R.id.add_genres);

        regionsRecyclerView = findViewById(R.id.producer_regions_recyclerView);
        addRegions = findViewById(R.id.add_regions);


        genreTagAdapter = new GenreTagAdapter(this, genresList);
        genresRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        genresRecyclerView.setLayoutManager(layoutManager);
        genresRecyclerView.setAdapter(genreTagAdapter);




        addGenres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, SelectGenreActivity.class);
                intent.putExtra("selected_genres_search", (Serializable) Profile.this.regionsList);
                startActivity(intent);
            }
        });

        addRegions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, SelectRegionActivity.class);
                intent.putExtra("selected_genres_search", (Serializable) Profile.this.regionsList);
                startActivity(intent);
            }
        });




        FloatingActionButton home_button = findViewById(R.id.home_button);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.profile_button);
        bottomNavigationView.setItemIconTintList(null);
        home_button.setBackgroundTintList(colorHomeConfig());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.favorites_button:
                        startActivity(new Intent(getApplicationContext(),Favorites.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile_button:
                        return true;
                    case R.id.chat_button:
                        startActivity(new Intent(getApplicationContext(),Chat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search_button:
                        startActivity(new Intent(getApplicationContext(),Search.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Home.class));
                overridePendingTransition(0, 0);

            }
        });
    }

    public ColorStateList colorHomeConfig() {
        ColorStateListBuilder builder = new ColorStateListBuilder();
        builder.addState(new int[]{android.R.attr.state_pressed}, Color.parseColor("#2196F3"));
        builder.addState(new int[]{android.R.attr.state_selected}, Color.WHITE);
        builder.addState(new int[]{}, Color.BLACK);
        ColorStateList stateList = builder.build();
        return stateList;
    }


}