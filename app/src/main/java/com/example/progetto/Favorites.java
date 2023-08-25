package com.example.progetto;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Favorites extends AppCompatActivity {



    ListView favoriteListView;
    List<Artist> artists = ArtistRepository.getInstance().artistList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);


        favoriteListView = (ListView) findViewById(R.id.favoritesList);
        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(getApplicationContext(), artists);
        favoriteListView.setAdapter(favoritesAdapter);


        FloatingActionButton home_button = findViewById(R.id.home_button);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.favorites_button);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home_button:
                        return true;
                    case R.id.chat_button:
                        startActivity(new Intent(getApplicationContext(),Chat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favorites_button:
                        return true;
                    case R.id.profile_button:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
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
            }
        });
    }
}