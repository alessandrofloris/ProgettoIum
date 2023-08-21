package com.example.progetto;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class PrivateChat extends AppCompatActivity {

    private EditText editText;
    private ImageButton showButton;
    private ImageButton backButton;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_chat);

        editText = findViewById(R.id.messageEditText);
        displayText = findViewById(R.id.messageView1);
        showButton = findViewById(R.id.sendButton);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editText.getText().toString();
                displayText.setText(inputText);
                displayText.setVisibility(View.VISIBLE);
            }
        });


    }
}