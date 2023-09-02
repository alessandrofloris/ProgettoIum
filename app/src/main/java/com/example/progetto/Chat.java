package com.example.progetto;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {

    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";
    Artist clickedArtist;
    List<Artist> textedArtists;
    ChatAdapter chatAdapter;
    RecyclerView chatRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        textedArtists = new ArrayList<>();
        textedArtists = ArtistService.getInstance().getTextedArtists();

        if(textedArtists.size()>0) {
            TextView errorMessage = findViewById(R.id.notTextedYet);
            errorMessage.setVisibility(View.GONE);
        }

        chatRecyclerView = findViewById(R.id.chat_recycler);
        chatAdapter = new ChatAdapter(this, textedArtists);
        chatRecyclerView.setAdapter(chatAdapter);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));




        FloatingActionButton home_button = findViewById(R.id.home_button);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.chat_button);
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
                    case R.id.chat_button:
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


    public ColorStateList colorHomeConfig() {
        ColorStateListBuilder builder = new ColorStateListBuilder();
        builder.addState(new int[] { android.R.attr.state_pressed }, Color.parseColor("#2196F3"));
        builder.addState(new int[] { android.R.attr.state_selected }, Color.WHITE);
        builder.addState(new int[] {}, Color.BLACK);
        ColorStateList stateList = builder.build();
        return stateList;
    }


    public void openArtistProfile(Artist artist) {
        Intent artistProfile = new Intent(getApplicationContext(), ArtistProfile.class);
        artistProfile.putExtra(ARTIST_EXTRA, artist);
        startActivity(artistProfile);
    }

}