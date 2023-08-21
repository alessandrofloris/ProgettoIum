package com.example.progetto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class Search extends AppCompatActivity{

    SearchView bar_search_view;
    LinearLayoutCompat no_search_content_view;
    ListView artists_list_view;
    TextView no_matching_results_view;
    MaterialCardView genre_badge_view;
    MaterialCardView region_badge_view;
    SearchAdapter adapter;
    List<Artist> artists = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

        bottomNavigationConfig();
        searchBarConfig();
        searchBadgesConfig();

        //general config

        no_search_content_view = findViewById(R.id.no_search_content);
        no_matching_results_view = findViewById(R.id.no_matching_results);
        artists_list_view = findViewById(R.id.artists_list);

        adapter = new SearchAdapter(this, artists);
        artists_list_view.setAdapter(adapter);

    }

    private void searchBadgesConfig() {

        genre_badge_view = findViewById(R.id.genre_badge);
        region_badge_view = findViewById(R.id.region_badge);

        region_badge_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, SelectRegionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void searchBarConfig() {
        bar_search_view = findViewById(R.id.search_bar);

        bar_search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nickname) {

                updateSearchResult(nickname);

                updateResultView(nickname);

                return false;
            }
        });
    }

    private void updateResultView(String nickname) {

        adapter.notifyDataSetChanged();

        if(artists.isEmpty()) {
            artists_list_view.setVisibility(View.GONE);
            if(nickname.isEmpty()) {
                no_matching_results_view.setVisibility(View.GONE);
                no_search_content_view.setVisibility(View.VISIBLE);
            } else {
                no_search_content_view.setVisibility(View.GONE);
                no_matching_results_view.setVisibility(View.VISIBLE);
            }
        } else {
            no_matching_results_view.setVisibility(View.GONE);
            no_search_content_view.setVisibility(View.GONE);
            artists_list_view.setVisibility(View.VISIBLE);
        }

    }

    private void updateSearchResult(String nickname) {
        artists.clear();
        if(!nickname.isEmpty()) {
            List<Artist> artists_ = ArtistService.getInstance().searchArtistsByPartialNickName(nickname);
            artists.addAll(artists_);
        }
    }

    private void bottomNavigationConfig() {

        FloatingActionButton home_button = findViewById(R.id.home_button);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);

        // Set Search selected
        bottomNavigationView.setSelectedItemId(R.id.search_button);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home_button:
                        return true;
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
            }
        });

    }

}