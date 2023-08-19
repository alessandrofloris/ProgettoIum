package com.example.progetto;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        LinearLayout linearLayoutButton1 = findViewById(R.id.profileButton1);
        linearLayoutButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chat.this, PrivateChat.class));
            }
        });

        LinearLayout linearLayoutButton2 = findViewById(R.id.profileButton2);
        linearLayoutButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chat.this, PrivateChat.class));
            }
        });

        LinearLayout linearLayoutButton3 = findViewById(R.id.profileButton3);
        linearLayoutButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chat.this, PrivateChat.class));
            }
        });

        FloatingActionButton home_button = findViewById(R.id.home_button);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.chat_button);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home_button:
                        return true;
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
            }
        });
    }
}