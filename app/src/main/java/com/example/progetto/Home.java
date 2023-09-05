package com.example.progetto;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements View.OnClickListener {

    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbarConfig();

        sideMenuConfig();

        RegistrationBean loggedUser = ProducerRepository.getInstance().getLoggedUser();

        //recyclerView list of popular artists
        ArrayList<Artist> popularArtists = (ArrayList<Artist>) ArtistService.getInstance().getPopularArtists();
        recycleViewPopularArtistConfig(popularArtists);

        //recyclerView list of suggested artists
        ArrayList<Artist> suggestedArtists;
        List<Genres> genres = loggedUser.getGenres();
        List<Locations> locations = loggedUser.getLocations();

        if(genres.isEmpty() && locations.isEmpty()) {
            findViewById(R.id.no_filters_error).setVisibility(View.VISIBLE);
        }
        else {
            if (!genres.isEmpty()) {
                if(!locations.isEmpty()) {
                    suggestedArtists = (ArrayList<Artist>) ArtistService.getInstance().searchArtistsByGenres(genres);
                    suggestedArtists = (ArrayList<Artist>) ArtistService.getInstance().filterByLocations(suggestedArtists, locations);
                }
                else {
                    suggestedArtists = (ArrayList<Artist>) ArtistService.getInstance().searchArtistsByGenres(genres);
                }
            }
            else {
                suggestedArtists = (ArrayList<Artist>) ArtistService.getInstance().searchArtistsByLocations(locations);
            }
            findViewById(R.id.no_filters_error).setVisibility(View.GONE);
            recycleViewRecommendedArtistConfig(suggestedArtists);
        }



        //Horizontal recyclerView list of artists near to you
        ArrayList<Artist> neartoyouArstists = (ArrayList<Artist>) ArtistService.getInstance().getAllArtist();
        recyclerViewNearToYouArtists(neartoyouArstists);

        bottomMenuConfig();
    }


    private void toolbarConfig() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(" ");
        toolbar.setTitleTextColor(Color.WHITE);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void recycleViewPopularArtistConfig(ArrayList<Artist> artistList) {
        RecyclerView recyclerViewPopularArtists = findViewById(R.id.recycle_populars);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        PopularsAdapter adapterPopularArtists = new PopularsAdapter(this, artistList, new PopularsAdapter.OnPopularsClickListener() {
            @Override
            public void onPopularsClick(PopularsAdapter.MyHolderP holder) {
                openArtistProfile(holder.artist);
            }
        });
        recyclerViewPopularArtists.setLayoutManager(flexboxLayoutManager);
        recyclerViewPopularArtists.setAdapter(adapterPopularArtists);

    }

    private void recycleViewRecommendedArtistConfig(ArrayList<Artist> artistList) {
        RecyclerView recyclerViewSuggestedArtists = findViewById(R.id.recycle_suggeritiperte);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ArtistListAdapter adapterSuggestedArtists = new ArtistListAdapter(this, artistList, new ArtistListAdapter.OnArtistClickListener() {
            @Override
            public void onArtistClick(ArtistListAdapter.MyHolder holder) {
                openArtistProfile(holder.artist);
            }
        });
        recyclerViewSuggestedArtists.setLayoutManager(linearLayoutManager1);
        recyclerViewSuggestedArtists.setAdapter(adapterSuggestedArtists);

    }

    private void recyclerViewNearToYouArtists(ArrayList<Artist> artistList) {
        RecyclerView recyclerViewNearToYouArtists = findViewById(R.id.recycle_neartoyou);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ArtistListAdapter adapterNearToYouArtists = new ArtistListAdapter(this, artistList, new ArtistListAdapter.OnArtistClickListener() {
            @Override
            public void onArtistClick(ArtistListAdapter.MyHolder holder) {
                openArtistProfile(holder.artist);
            }
        });
        recyclerViewNearToYouArtists.setLayoutManager(linearLayoutManager2);
        recyclerViewNearToYouArtists.setAdapter(adapterNearToYouArtists);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    public void openArtistProfile(Artist artist) {
        Intent artistProfile = new Intent(getApplicationContext(), ArtistProfile.class);
        artistProfile.putExtra(ARTIST_EXTRA, artist);
        startActivity(artistProfile);
    }

    public void sideMenuConfig() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setTitle(ProducerRepository.getInstance().getUtente("admin").getUsername());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_settings:
                        Snackbar.make(navigationView, "Funzionalità non implementata.", Snackbar.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_aboutus:
                        Snackbar.make(navigationView, "Funzionalità non implementata.", Snackbar.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_exit:
                        Snackbar.make(navigationView, "Funzionalità non implementata.", Snackbar.LENGTH_SHORT).show();
                        return true;
                }
            return false;
            }
        });
    }

    public void bottomMenuConfig() {
        FloatingActionButton home_button = findViewById(R.id.home_button);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.empty);
        bottomNavigationView.setItemIconTintList(null);
        home_button.setBackgroundTintList(colorHomeConfig());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.favorites_button:
                        startActivity(new Intent(getApplicationContext(), Favorites.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.chat_button:
                        startActivity(new Intent(getApplicationContext(), Chat.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile_button:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.search_button:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    public ColorStateList colorHomeConfig() {
        ColorStateListBuilder builder = new ColorStateListBuilder();
        builder.addState(new int[] { android.R.attr.state_pressed }, Color.parseColor("#2196F3"));
        builder.addState(new int[] { android.R.attr.state_selected }, Color.WHITE);
        builder.addState(new int[] {}, Color.parseColor("#2196F3"));
        ColorStateList stateList = builder.build();
        return stateList;
    }

    @Override
    public void onClick(View view) {}
}