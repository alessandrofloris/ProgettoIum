package com.example.progetto;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity {


    FavoritesAdapter favoritesAdapter;
    List<Artist> likedArtists;
    String messageNumberLikedArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        likedArtists = new ArrayList<>();
        likedArtists = ArtistService.getInstance().getLikedArtists();

        TextView nLikedArtists = findViewById(R.id.number_liked_artist);
        messageNumberLikedArtists = "Artisti piaciuti: "+ likedArtists.size();
        nLikedArtists.setText(messageNumberLikedArtists);

        findViewById(R.id.sortBy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Funzionalità non implementata.", Snackbar.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.search_favorites).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Funzionalità non implementata.", Snackbar.LENGTH_SHORT).show();
            }
        });

        if(likedArtists.size()>0) {
            TextView errorMessage = findViewById(R.id.nochatyet_message);
            errorMessage.setVisibility(View.GONE);
            RecyclerView favoriteRecyclerView = findViewById(R.id.recycler_favorites);
            favoriteRecyclerView.setHasFixedSize(true);
            favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            List<Artist> finalLikedArtists = likedArtists;
            favoritesAdapter = new FavoritesAdapter(this, likedArtists, new FavoritesAdapter.OnFavoriteClickListener() {

                @Override
                public void onFavoriteClick(FavoritesAdapter.FavoritesHolder holder, int position, View view) {
                    finalLikedArtists.remove(position);
                    favoritesAdapter.notifyItemRemoved(position);
                    ArtistRepository.getInstance().artistList.get(holder.artistID).setLiked(false);
                    Snackbar.make(view, "Hai rimosso "+ ArtistRepository.getInstance().artistList.get(holder.artistID).getNomeDarte() + " dalla lista dei preferiti.", Snackbar.LENGTH_SHORT).show();

                    likedArtists = ArtistService.getInstance().getLikedArtists();
                    messageNumberLikedArtists ="Artisti piaciuti: "+likedArtists.size();
                    nLikedArtists.setText(messageNumberLikedArtists);
                    if(likedArtists.size()==0)
                        errorMessage.setVisibility(View.VISIBLE);
                }
            });
            favoriteRecyclerView.setAdapter(favoritesAdapter);
        }

        bottomMenuConfig();

    }

    public ColorStateList colorHomeConfig() {
        ColorStateListBuilder builder = new ColorStateListBuilder();
        builder.addState(new int[]{android.R.attr.state_pressed}, Color.parseColor("#2196F3"));
        builder.addState(new int[]{android.R.attr.state_selected}, Color.WHITE);
        builder.addState(new int[]{}, Color.BLACK);
        ColorStateList stateList = builder.build();
        return stateList;
    }


    public void bottomMenuConfig() {
        FloatingActionButton home_button = findViewById(R.id.home_button);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.favorites_button);
        bottomNavigationView.setItemIconTintList(null);
        home_button.setBackgroundTintList(colorHomeConfig());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
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
                overridePendingTransition(0, 0);
            }
        });


    }
}