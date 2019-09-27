package com.example.listviewitemselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Description extends AppCompatActivity {
    private Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        returnButton = (Button) findViewById(R.id.ReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { finish();  }
        });
        Intent intent = getIntent();
        String message =
                intent.getStringExtra(MainActivity.MESSAGE);
        TextView textView = (TextView)
                findViewById(R.id.textDescription);
        textView.setText(message);
    }  // end of onCreate()
}  // end of class Description

