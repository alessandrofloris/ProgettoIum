package com.example.progetto;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;


public class PrivateChat extends AppCompatActivity {

    private EditText editText;
    private ImageButton showButton;
    private ImageButton backButton;
    private LinearLayout messageSentLayout;
    private LinearLayout messageReceivedLayout;
    private LinearLayout artistIconLayout;
    private TextView displayText;
    private TextView artistName;
    private ImageView profilePhoto;
    private Artist artist;
    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_chat);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(Home.ARTIST_EXTRA);
        artist = (Artist) obj;
        editText = findViewById(R.id.messageEditText);
        artistName = findViewById(R.id.artist_name);
        artistName.setText(artist.getNomeDarte());
        profilePhoto = findViewById(R.id.profileView);
        profilePhoto.setImageResource(artist.getImgID());
        displayText = findViewById(R.id.right_chat_textView);
        displayText = findViewById(R.id.right_chat_textView);
        showButton = findViewById(R.id.sendButton);
        backButton = findViewById(R.id.backButton);
        artistIconLayout = findViewById(R.id.topLinearLayout);
        messageSentLayout = findViewById(R.id.right_chat_layout);
        //messageReceivedLayout = findViewById(R.id.left_chat_layout);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editText.getText().toString();
                displayText.setText(inputText);
                messageSentLayout.setVisibility(View.VISIBLE);
                editText.setText("");
               // messageReceivedLayout.setVisibility(View.VISIBLE);
            }
        });


        artistIconLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArtistProfile.class);
                intent.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(artist.getIdArtist()));
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}