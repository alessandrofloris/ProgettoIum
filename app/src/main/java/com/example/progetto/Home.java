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


public class Home extends AppCompatActivity {

    public ActionBarDrawerToggle actionBarDrawerToggle;

    // Risorse per il menu laterlae
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView cardView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Gestione del menù laterale
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Artista posizione 1
        TextView printArtist1 = (TextView) findViewById(R.id.artista1);
        printArtist1.setText(Artist.artist1.getNomeDarte());
        ImageView printImg1 = (ImageView) findViewById(R.id.imageView1);
        printImg1.setImageResource(Artist.artist1.getImgID());
        cardView1 = findViewById(R.id.card_artist_1);

        // Artista posizione 2
        TextView printArtist2 = (TextView) findViewById(R.id.artista2);
        printArtist2.setText(Artist.artist2.getNomeDarte());
        ImageView printImg2 = (ImageView) findViewById(R.id.imageView2);
        printImg2.setImageResource(Artist.artist2.getImgID());

        // Artista posizione 3
        TextView printArtist3 = (TextView) findViewById(R.id.artista3);
        printArtist3.setText(Artist.artist3.getNomeDarte());
        ImageView printImg3 = (ImageView) findViewById(R.id.imageView3);
        printImg3.setImageResource(Artist.artist3.getImgID());

        // Artista posizione 4
        TextView printArtist4 = (TextView) findViewById(R.id.artista4);
        printArtist4.setText(Artist.artist4.getNomeDarte());
        ImageView printImg4 = (ImageView) findViewById(R.id.imageView4);
        printImg4.setImageResource(Artist.artist4.getImgID());

        // Artista posizione 5
        TextView printArtist5 = (TextView) findViewById(R.id.artista5);
        printArtist5.setText(Artist.artist5.getNomeDarte());
        ImageView printImg5 = (ImageView) findViewById(R.id.imageView5);
        printImg5.setImageResource(Artist.artist5.getImgID());

        // Artista posizione 6
        TextView printArtist6 = (TextView) findViewById(R.id.artista6);
        printArtist6.setText(Artist.artist6.getNomeDarte());
        ImageView printImg6 = (ImageView) findViewById(R.id.imageView6);
        printImg6.setImageResource(Artist.artist6.getImgID());

        // Artista posizione 7
        TextView printArtist7 = (TextView) findViewById(R.id.artista7);
        printArtist7.setText(Artist.artist7.getNomeDarte());
        ImageView printImg7 = (ImageView) findViewById(R.id.imageView7);
        printImg7.setImageResource(Artist.artist7.getImgID());

        // Artista posizione 8
        TextView printArtist8 = (TextView) findViewById(R.id.artista8);
        printArtist8.setText(Artist.artist8.getNomeDarte());
        ImageView printImg8 = (ImageView) findViewById(R.id.imageView8);
        printImg8.setImageResource(Artist.artist8.getImgID());

        // Artista posizione 9
        TextView printArtist9 = (TextView) findViewById(R.id.artista9);
        printArtist9.setText(Artist.artist9.getNomeDarte());
        ImageView printImg9 = (ImageView) findViewById(R.id.imageView9);
        printImg9.setImageResource(Artist.artist9.getImgID());

        // Artista posizione 10
        TextView printArtist10 = (TextView) findViewById(R.id.artista10);
        printArtist10.setText(Artist.artist10.getNomeDarte());
        ImageView printImg10 = (ImageView) findViewById(R.id.imageView10);
        printImg10.setImageResource(Artist.artist10.getImgID());

        // Artista posizione 11
        TextView printArtist11 = (TextView) findViewById(R.id.artista11);
        printArtist11.setText(Artist.artist11.getNomeDarte());
        ImageView printImg11 = (ImageView) findViewById(R.id.imageView11);
        printImg11.setImageResource(Artist.artist11.getImgID());

        // Artista posizione 12
        TextView printArtist12 = (TextView) findViewById(R.id.artista12);
        printArtist12.setText(Artist.artist12.getNomeDarte());
        ImageView printImg12 = (ImageView) findViewById(R.id.imageView12);
        printImg12.setImageResource(Artist.artist12.getImgID());

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

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ArtistProfile.class));
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


}