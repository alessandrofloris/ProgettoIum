package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.Serializable;

public class ArtistProfile extends AppCompatActivity {

    Artist artist;
    ImageView profilePic;
    TextView nomeDarte, nomeArtista, cognomeArtista, bio;
    View previous_activity_button;
    Button videoFragment, photoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_profile);
        previous_activity_button = findViewById(R.id.previous_activity_button1);
        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(Home.ARTIST_EXTRA);
        artist = (Artist) obj;

        profilePic = findViewById(R.id.artist_profile_pic);
        profilePic.setImageResource(artist.getImgID());
        nomeDarte = findViewById(R.id.artist_stage_name);
        nomeDarte.setText(artist.getNomeDarte());
        nomeArtista =findViewById(R.id.artist_name);
        nomeArtista.setText(artist.getNome());
        cognomeArtista =findViewById(R.id.artist_surname);
        cognomeArtista.setText(artist.getCognome());
        bio =findViewById(R.id.bio);
        bio.setText(artist.getShortDesc());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,new FragmentVideos());
        fragmentTransaction.commit();

        videoFragment = findViewById(R.id.video_section);
        photoFragment = findViewById(R.id.photo_section);

        videoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FragmentVideos());
            }
        });

        photoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FragmentPhotos());
            }
        });


        previous_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(ArtistProfile.this, Home.class);
                startActivity(goBack);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


}