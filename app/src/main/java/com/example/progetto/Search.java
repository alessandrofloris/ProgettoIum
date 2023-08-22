package com.example.progetto;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

    ArrayList<Locations> selectedLocations;
    ArrayList<Genres> selectedGenres;
    String nickname;



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

        nickname = "";
        selectedLocations = new ArrayList<>();
        selectedGenres = new ArrayList<>();

    }

    public ActivityResultLauncher<Intent> startActivityIntentLocation = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent intent = result.getData();

                    try{
                        selectedLocations = (ArrayList<Locations>)intent.getSerializableExtra("selected_locations");
                        updateSearch();
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
                        updateSearch();
                    } catch (Exception e) {
                        Log.d("Get Extra From Intent", e.toString());
                    }

                }
            });

    private void updateFilter(FiltersInterface filter) {

        if(filter instanceof Locations) {

        }

    }

    /**
     * Questo metodo viene chiamato quando viene modificata la stringa di ricerca
     * o quando vengono modificati i filtri
     * */
    private void updateSearch() {

        artists.clear();
        List<Artist> artists_ = new ArrayList<>();

        if(nickname.isEmpty()) {

            if(selectedLocations.size() > 0) {
                // ci sono dei filtri sui luoghi di residenza
                artists_ = ArtistService.getInstance().searchArtistsByLocations(selectedLocations);

                if(selectedGenres.size() > 0) {
                    // ci sono dei filtri suo generi
                    artists_ = ArtistService.getInstance().filterByGenres(artists_, selectedGenres);

                }
            } else {
                if(selectedGenres.size() > 0) {
                    // ci sono dei filtri suo generi
                    artists_ = ArtistService.getInstance().searchArtistsByGenres(selectedGenres);
                }
            }
        }

        if(!nickname.isEmpty()) {
            artists_ = ArtistService.getInstance().searchArtistsByPartialNickName(nickname);
            if(!artists_.isEmpty() && !selectedLocations.isEmpty()) {
                artists_ = ArtistService.getInstance().filterByLocations(artists_, selectedLocations);
//                artists_ = ArtistService.getInstance().filterByGenres(artists_, selectedGenres);
            }
            if(!artists_.isEmpty() && !selectedGenres.isEmpty()) {
//                artists_ = ArtistService.getInstance().filterByLocations(artists_, selectedLocations);
                artists_ = ArtistService.getInstance().filterByGenres(artists_, selectedGenres);
            }
        }

        artists.addAll(artists_);

        updateResultView();

    }

    private void searchBadgesConfig() {

        genre_badge_view = findViewById(R.id.genre_badge);
        region_badge_view = findViewById(R.id.region_badge);

        genre_badge_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, SelectGenreActivity.class);
                startActivityIntentGenre.launch(intent);
            }
        });

        region_badge_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, SelectRegionActivity.class);
                startActivityIntentLocation.launch(intent);
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

                Search.this.nickname = nickname;

                updateSearch();
                //updateSearchResult(nickname);
                //updateResultView();

                return false;
            }
        });
    }

    private void updateResultView() {

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

//    private void updateSearchResult(String nickname) {
//        artists.clear();
//        if(!nickname.isEmpty()) {
//            List<Artist> artists_ = ArtistService.getInstance().searchArtistsByPartialNickName(nickname);
//            artists.addAll(artists_);
//        }
//    }

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