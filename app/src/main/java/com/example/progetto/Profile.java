package com.example.progetto;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Region;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Profile extends AppCompatActivity {


    ImageButton addGenres;
    ImageButton addLocations;

    ArrayList<Locations> selectedLocations;
    ArrayList<Genres> selectedGenres;
    ChipGroup genres_chip_group_view;
    ChipGroup locations_chip_group_view;


    FlexboxLayout selected_genres_container_view;
    FlexboxLayout selected_regions_container_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        addGenres = findViewById(R.id.add_genres);
        addLocations = findViewById(R.id.add_regions);
        genres_chip_group_view = findViewById(R.id.genres_chip_group);
        locations_chip_group_view = findViewById(R.id.regions_chip_group);

        selected_genres_container_view = findViewById(R.id.genres_chip_layout);
        selected_regions_container_view = findViewById(R.id.regions_chip_layout);



        addGenres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, SelectGenreActivity.class);
                intent.putExtra("selected_genres_search", (Serializable) Profile.this.selectedGenres);
                startActivityIntentGenre.launch(intent);
            }
        });

        addLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, SelectRegionActivity.class);
                intent.putExtra("selected_locations_search", (Serializable) Profile.this.selectedLocations);
                startActivityIntentLocation.launch(intent);
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


    public ActivityResultLauncher<Intent> startActivityIntentLocation = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent intent = result.getData();

                    try{
                        selectedLocations = (ArrayList<Locations>)intent.getSerializableExtra("selected_locations");
                        updateLocations();
                    } catch (Exception e) {
                        Log.d("Get Extra From Intent", e.toString());
                    }

                }
            });

    public ActivityResultLauncher<Intent> startActivityIntentGenre = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent intent = result.getData();

                    try{
                        selectedGenres = (ArrayList<Genres>)intent.getSerializableExtra("selected_genres");
                        updateGenres();
                    } catch (Exception e) {
                        Log.d("Get Extra From Intent", e.toString());
                    }

                }
            });

    private void updateLocations() {

        locations_chip_group_view.removeAllViews();
        Chip chip;

        for(Locations location : this.selectedLocations) {
            chip = new Chip(this);
            chip.setId(ViewCompat.generateViewId());
            chip.setText(location.getDesc());
            chip.setCloseIconVisible(true);
            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Chip chip = (Chip) view;
                    locations_chip_group_view.removeView(chip);
                    ArrayList<Locations> newSelectedLocations = new ArrayList<>();
                    for(Locations location : selectedLocations) {
                        if(!location.getDesc().equals(chip.getText())) {
                            newSelectedLocations.add(location);
                        }
                    }
                    selectedLocations = newSelectedLocations;
                }
            });
            locations_chip_group_view.addView(chip);
        }

    }

    private void updateGenres() {

        genres_chip_group_view.removeAllViews();
        Chip chip;
        for(Genres genre : this.selectedGenres) {
            chip = new Chip(this);
            chip.setId(ViewCompat.generateViewId());
            chip.setText(genre.getDesc());
            chip.setCloseIconVisible(true);
            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Chip chip = (Chip) view;
                    genres_chip_group_view.removeView(chip);
                    ArrayList<Genres> newSelectedGenres = new ArrayList<>();
                    for(Genres genre : selectedGenres) {
                        if(!genre.getDesc().equals(chip.getText())) {
                            newSelectedGenres.add(genre);
                        }
                    }
                    selectedGenres = newSelectedGenres;
                }
            });
            genres_chip_group_view.addView(chip);
        }



    }

}