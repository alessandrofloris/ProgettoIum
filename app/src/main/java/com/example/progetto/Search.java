package com.example.progetto;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.ViewCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Search extends AppCompatActivity{

    SearchView bar_search_view;
    LinearLayoutCompat no_search_content_view;
    ListView artists_list_view;
    LinearLayout no_results_found_content_view;
    LinearLayout selected_filters_container_view;
    LinearLayout results_found_content_view;
    MaterialCardView genre_badge_view;
    MaterialCardView region_badge_view;
    ChipGroup filters_chip_group_view;
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
        resultRecyclerViewInizialization();
        searchFiltersInitialization();
    }

    private void searchFiltersInitialization() {
        nickname = "";
        selectedLocations = new ArrayList<>();
        selectedGenres = new ArrayList<>();
    }

    private void resultRecyclerViewInizialization() {
        selected_filters_container_view = findViewById(R.id.selected_filters_container);
        no_search_content_view = findViewById(R.id.no_filters_selected_content);
        no_results_found_content_view = findViewById(R.id.no_results_found_content);
        results_found_content_view = findViewById(R.id.results_found_content);
        artists_list_view = findViewById(R.id.artists_list);
        adapter = new SearchAdapter(this, artists);
        artists_list_view.setAdapter(adapter);
    }

    private void searchBadgesConfig() {

        genre_badge_view = findViewById(R.id.genre_badge);
        region_badge_view = findViewById(R.id.region_badge);
        filters_chip_group_view = findViewById(R.id.filters_chip_group);

        genre_badge_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, SelectGenreActivity.class);
                intent.putExtra("selected_genres_search", (Serializable) Search.this.selectedGenres);
                startActivityIntentGenre.launch(intent);
            }
        });

        region_badge_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, SelectRegionActivity.class);
                intent.putExtra("selected_locations_search", (Serializable) Search.this.selectedLocations);
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

                return false;
            }
        });
    }

    private void bottomNavigationConfig() {
        FloatingActionButton home_button = findViewById(R.id.home_button);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.search_button);
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
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.chat_button:
                        startActivity(new Intent(getApplicationContext(),Chat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search_button:
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

    public ActivityResultLauncher<Intent> startActivityIntentLocation = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent intent = result.getData();

                    try{
                        selectedLocations = (ArrayList<Locations>)intent.getSerializableExtra("selected_locations");
                        updateSearch();
                        updateFilters();
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
                        updateFilters();
                    } catch (Exception e) {
                        Log.d("Get Extra From Intent", e.toString());
                    }

                }
            });

    private void updateFilters() {

        filters_chip_group_view.removeAllViews();
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
                    filters_chip_group_view.removeView(chip);
                    ArrayList<Genres> newSelectedGenres = new ArrayList<>();
                    for(Genres genre : selectedGenres) {
                        if(!genre.getDesc().equals(chip.getText())) {
                            newSelectedGenres.add(genre);
                        }
                    }
                    selectedGenres = newSelectedGenres;
                    updateSearch();
                }
            });
            filters_chip_group_view.addView(chip);
        }
        for(Locations location : this.selectedLocations) {
            chip = new Chip(this);
            chip.setId(ViewCompat.generateViewId());
            chip.setText(location.getDesc());
            chip.setCloseIconVisible(true);
            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Chip chip = (Chip) view;
                    filters_chip_group_view.removeView(chip);
                    ArrayList<Locations> newSelectedLocations = new ArrayList<>();
                    for(Locations location : selectedLocations) {
                        if(!location.getDesc().equals(chip.getText())) {
                            newSelectedLocations.add(location);
                        }
                    }
                    selectedLocations = newSelectedLocations;
                    updateSearch();
                }
            });
            filters_chip_group_view.addView(chip);
        }

    }

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

    private void updateResultView() {
        adapter.notifyDataSetChanged();

        if(this.thereAreActiveFilters()) {
            // siamo in modalità ricerca, dunque abbiamo due possibili visualizzazioni
            // 1. la ricerca ha prodotto dei risultati e vengono mostrati
            //      1.1 un filtro genere o regione è attivo, dunque deve essere mostrata la lista di filtri attivi
            // 2. la ricerca non ha prodotto dei risultati e viene mostrato il messaggio per informare l'utente
            if(this.areGenreOrLocationsFiltersActive()) {
                // esiste un qualche filtro per regione o genere
                selected_filters_container_view.setVisibility(View.VISIBLE);
            } else {
                // non è stato selezionato nessun filtro regione o genere
                selected_filters_container_view.setVisibility(View.GONE);
            }

            if(this.noResultsFound()) {
                // non ci sono risultati
                no_search_content_view.setVisibility(View.GONE);
                results_found_content_view.setVisibility(View.GONE);
                no_results_found_content_view.setVisibility(View.VISIBLE);
            } else {
                // ci sono dei risultati
                no_results_found_content_view.setVisibility(View.GONE);
                no_search_content_view.setVisibility(View.GONE);
                results_found_content_view.setVisibility(View.VISIBLE);
            }
        } else {
            // non siamo in modalità ricerca, dunque viene mostrato il messaggio iniziale
            results_found_content_view.setVisibility(View.GONE);
            no_results_found_content_view.setVisibility(View.GONE);
            selected_filters_container_view.setVisibility(View.GONE);
            no_search_content_view.setVisibility(View.VISIBLE);
        }
    }

    private Boolean thereAreActiveFilters() {
        return (!this.nickname.isEmpty() || !this.selectedGenres.isEmpty() || !this.selectedLocations.isEmpty());
    }

    private Boolean areGenreOrLocationsFiltersActive() {
        return (!this.selectedGenres.isEmpty() || !this.selectedLocations.isEmpty());
    }

    private Boolean noResultsFound() {
        return this.artists.isEmpty();
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