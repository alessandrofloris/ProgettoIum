package com.example.progetto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Chat extends AppCompatActivity {

    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";
    Artist clickedArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        TextView[] textViewsNames = new TextView[3];
        textViewsNames[0] =(TextView) findViewById(R.id.artist_name1);
        textViewsNames[1] =(TextView) findViewById(R.id.artist_name2);
        textViewsNames[2] =(TextView) findViewById(R.id.artist_name3);;

        ImageView[] imageViewsProfile = new ImageView[3];
        imageViewsProfile[0] = (ImageView) findViewById(R.id.profileView1);
        imageViewsProfile[1] = (ImageView) findViewById(R.id.profileView2);
        imageViewsProfile[2] = (ImageView) findViewById(R.id.profileView3);

        for(int i=0; i<=2;i++) {
            Artist tmpArtist =ArtistService.getInstance().getById(i);
            textViewsNames[i].setText(tmpArtist.getNomeDarte());
            imageViewsProfile[i].setImageResource(tmpArtist.getImgID());
        }




        LinearLayout linearLayoutButton1 = findViewById(R.id.profileButton1);
        linearLayoutButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedArtist = ArtistRepository.getInstance().artistList.get(0);
                Intent privateChat = new Intent(getApplicationContext(), PrivateChat.class);
                privateChat.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(0));
                startActivity(privateChat);
            }
        });

        LinearLayout linearLayoutButton2 = findViewById(R.id.profileButton2);
        linearLayoutButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedArtist = ArtistRepository.getInstance().artistList.get(1);
                Intent privateChat = new Intent(getApplicationContext(), PrivateChat.class);
                privateChat.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(1));
                startActivity(privateChat);
            }
        });

        LinearLayout linearLayoutButton3 = findViewById(R.id.profileButton3);
        linearLayoutButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedArtist = ArtistRepository.getInstance().artistList.get(2);
                Intent privateChat = new Intent(getApplicationContext(), PrivateChat.class);
                privateChat.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(2));
                startActivity(privateChat);
            }
        });

        FloatingActionButton home_button = findViewById(R.id.home_button);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.chat_button);
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
}