package com.example.progetto;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class ArtistProfile extends AppCompatActivity {


    VideoView videoView1;
    ImageView profilePic;
    TextView nomeDarte, nomeArtista, cognomeArtista;
    View previous_activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_profile);
        previous_activity_button = findViewById(R.id.previous_activity_button1);

        profilePic = findViewById(R.id.artist_profile_pic);
        profilePic.setImageResource(Artist.artist1.getImgID());

        nomeDarte = findViewById(R.id.artist_stage_name);
        nomeDarte.setText(Artist.artist1.getNomeDarte());

        nomeArtista =findViewById(R.id.artist_name);
        nomeArtista.setText(Artist.artist1.getNome());

        cognomeArtista =findViewById(R.id.artist_surname);
        cognomeArtista.setText(Artist.artist1.getCognome());



        videoView1 = findViewById(R.id.video_view);
        String vPath = "android.resource://" + getPackageName() + "/raw/rinfiggivideo2";

        Uri videoURI = Uri.parse(vPath);

        videoView1.setVideoURI(videoURI);
        videoView1.start();

        MediaController mediaController = new MediaController(this);
        videoView1.setMediaController(mediaController);
        mediaController.setAnchorView(videoView1);


        previous_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(ArtistProfile.this, Home.class);
                startActivity(goBack);
            }
        });
    }




}