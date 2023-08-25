package com.example.progetto;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistProfile extends AppCompatActivity {

    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";

    Artist artist;
    ImageView profilePic, heartShape;
    TextView nomeDarte, nomeArtista, cognomeArtista, bio, likeText;
    View previous_activity_button;
    MaterialCardView videoFragment, photoFragment, audioFragment, likeButton;
    Button messageButton;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_profile);

        artist = new Artist();
        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(Home.ARTIST_EXTRA);
        artist = (Artist) obj;

        profilePic = findViewById(R.id.artist_profile_pic);
        nomeDarte = findViewById(R.id.artist_stage_name);
        nomeArtista =findViewById(R.id.artist_name);
        cognomeArtista =findViewById(R.id.artist_surname);
        bio =findViewById(R.id.bio);
        likeButton = findViewById(R.id.like_button_card);
        heartShape = findViewById(R.id.heart);
        likeText = findViewById(R.id.like_button);
        messageButton = findViewById(R.id.message_button);

        nomeDarte.setText(artist.getNomeDarte());
        profilePic.setImageResource(artist.getImgID());
        nomeArtista.setText(artist.getNome());
        cognomeArtista.setText(artist.getCognome());
        bio.setText(artist.getShortDesc());


        changeLikeButton(artist.isLiked());
        toolbarConfig();


        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer artistIndex = (Integer) artist.getIdArtist();
                if(artist.isLiked()) {
                    ArtistService.getInstance().getAllArtist().get(artistIndex).setLiked(false);
                    artist.setLiked(false);
                }
                else{
                    ArtistService.getInstance().getAllArtist().get(artistIndex).setLiked(true);
                    artist.setLiked(true);
                }
                changeLikeButton(artist.isLiked());
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent privateChat = new Intent(getApplicationContext(), PrivateChat.class);
                privateChat.putExtra(ARTIST_EXTRA, getCurrentArtist());
                startActivity(privateChat);
            }
        });


        if (artist.getGeneri() != null) {
            TextView genreTag = (TextView) findViewById(R.id.genere);
            RecyclerView recyclerView = findViewById(R.id.artist_genres_recyclerview);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new GenreTagAdapter(this, Arrays.asList(artist.getGeneri())));
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,new FragmentVideos());
        fragmentTransaction.commit();

        videoFragment = findViewById(R.id.card_video);
        photoFragment = findViewById(R.id.card_photo);
        audioFragment = findViewById(R.id.card_audio);

        videoFragment.setCardBackgroundColor(Color.parseColor("#C7D0D6"));

        videoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoFragment.setCardBackgroundColor(Color.parseColor("#C7D0D6"));
                photoFragment.setCardBackgroundColor(Color.WHITE);
                audioFragment.setCardBackgroundColor(Color.WHITE);
                replaceFragment(new FragmentVideos());
            }
        });

        photoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoFragment.setCardBackgroundColor(Color.parseColor("#C7D0D6"));
                audioFragment.setCardBackgroundColor(Color.WHITE);
                videoFragment.setCardBackgroundColor(Color.WHITE);
                replaceFragment(new FragmentPhotos());
            }
        });

        audioFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioFragment.setCardBackgroundColor(Color.parseColor("#C7D0D6"));
                photoFragment.setCardBackgroundColor(Color.WHITE);
                videoFragment.setCardBackgroundColor(Color.WHITE);
                replaceFragment(new FragmentAudio());
            }
        });

    }

    private void toolbarConfig() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    public Artist getCurrentArtist() {
        return artist;
    }

    public void changeLikeButton(boolean likeFlag) {
        if(likeFlag) {
            likeButton.setCardBackgroundColor(Color.parseColor("#D33656"));
            heartShape.setImageResource(R.drawable.fullheart_like);
            likeText.setTextColor(Color.WHITE);
            likeText.setText("LIKED");
        }
        else {
            likeButton.setCardBackgroundColor(Color.WHITE);
            heartShape.setImageResource(R.drawable.heart_nolike);
            likeText.setTextColor(Color.BLACK);
            likeText.setText("LIKE");
        }
    }
}