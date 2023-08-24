package com.example.progetto;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Home extends AppCompatActivity implements View.OnClickListener {

    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Integer numArtists = 12;
    Artist clickedArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        TextView[] textViews = new TextView[numArtists];
        textViews[0] =(TextView) findViewById(R.id.artista0);
        textViews[1] =(TextView) findViewById(R.id.artista1);
        textViews[2] =(TextView) findViewById(R.id.artista2);
        textViews[3] =(TextView) findViewById(R.id.artista3);
        textViews[4] =(TextView) findViewById(R.id.artista4);
        textViews[5] =(TextView) findViewById(R.id.artista5);
        textViews[6] =(TextView) findViewById(R.id.artista6);
        textViews[7] =(TextView) findViewById(R.id.artista7);
        textViews[8] =(TextView) findViewById(R.id.artista8);
        textViews[9] =(TextView) findViewById(R.id.artista9);
        textViews[10] =(TextView) findViewById(R.id.artista10);
        textViews[11] =(TextView) findViewById(R.id.artista11);

        ImageView[] imageViews = new ImageView[numArtists];
        imageViews[0] = (ImageView) findViewById(R.id.imageView0);
        imageViews[1] = (ImageView) findViewById(R.id.imageView1);
        imageViews[2] = (ImageView) findViewById(R.id.imageView2);
        imageViews[3] = (ImageView) findViewById(R.id.imageView3);
        imageViews[4] = (ImageView) findViewById(R.id.imageView4);
        imageViews[5] = (ImageView) findViewById(R.id.imageView5);
        imageViews[6] = (ImageView) findViewById(R.id.imageView6);
        imageViews[7] = (ImageView) findViewById(R.id.imageView7);
        imageViews[8] = (ImageView) findViewById(R.id.imageView8);
        imageViews[9] = (ImageView) findViewById(R.id.imageView9);
        imageViews[10] = (ImageView) findViewById(R.id.imageView10);
        imageViews[11] = (ImageView) findViewById(R.id.imageView11);

        CardView[] cardViews = new CardView[numArtists];
        cardViews[0] = findViewById(R.id.card_artist_0);
        cardViews[1] = findViewById(R.id.card_artist_1);
        cardViews[2] = findViewById(R.id.card_artist_2);
        cardViews[3] = findViewById(R.id.card_artist_3);
        cardViews[4] = findViewById(R.id.card_artist_4);
        cardViews[5] = findViewById(R.id.card_artist_5);
        cardViews[6] = findViewById(R.id.card_artist_6);
        cardViews[7] = findViewById(R.id.card_artist_7);
        cardViews[8] = findViewById(R.id.card_artist_8);
        cardViews[9] = findViewById(R.id.card_artist_9);
        cardViews[10] = findViewById(R.id.card_artist_10);
        cardViews[11] = findViewById(R.id.card_artist_11);


        for(int i=0; i<=11;i++) {
            Artist tmpArtist =ArtistService.getInstance().getById(i);
            textViews[i].setText(tmpArtist.getNomeDarte());
            imageViews[i].setImageResource(tmpArtist.getImgID());
            cardViews[i].setOnClickListener(this);
        }


        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // Gestione del bottom menù
        FloatingActionButton home_button = findViewById(R.id.home_button);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home_button);
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
                    case R.id.home_button:
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

        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void printArtist(Artist artistToPrint) {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_artist_0:
                openArtistProfile(0);
                break;
            case R.id.card_artist_1:
                openArtistProfile(1);
                break;
            case R.id.card_artist_2:
                openArtistProfile(2);
                break;
            case R.id.card_artist_3:
                openArtistProfile(3);
                break;
            case R.id.card_artist_4:
                openArtistProfile(4);
                break;
            case R.id.card_artist_5:
                openArtistProfile(5);
                break;
            case R.id.card_artist_6:
                openArtistProfile(6);
                break;
            case R.id.card_artist_7:
                openArtistProfile(7);
                break;
            case R.id.card_artist_8:
                openArtistProfile(8);
                break;
            case R.id.card_artist_9:
                openArtistProfile(9);
                break;
            case R.id.card_artist_10:
                openArtistProfile(10);
                break;
            case R.id.card_artist_11:
                openArtistProfile(11);
                break;
            default:
                break;

        }
    }

    public void openArtistProfile(Integer i) {
        clickedArtist = new Artist();
        clickedArtist = ArtistRepository.getInstance().artistList.get(i);
        Intent artistProfile = new Intent(getApplicationContext(), ArtistProfile.class);
        artistProfile.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(i));
        startActivity(artistProfile);
    }
}