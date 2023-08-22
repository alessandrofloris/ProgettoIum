package com.example.progetto;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class PrivateChat extends AppCompatActivity {

    private EditText editText;
    private ImageButton showButton;
    private ImageButton backButton;
    private LinearLayout messageSentLayout;
    private LinearLayout messageReceivedLayout;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_chat);


        editText = findViewById(R.id.messageEditText);
        displayText = findViewById(R.id.right_chat_textView);
        displayText = findViewById(R.id.right_chat_textView);
        showButton = findViewById(R.id.sendButton);
        backButton = findViewById(R.id.backButton);
        messageSentLayout = findViewById(R.id.right_chat_layout);
        messageReceivedLayout = findViewById(R.id.left_chat_layout);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editText.getText().toString();
                displayText.setText(inputText);
                messageSentLayout.setVisibility(View.VISIBLE);
                editText.setText("");
                messageReceivedLayout.setVisibility(View.VISIBLE);
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