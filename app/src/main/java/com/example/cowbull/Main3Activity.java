package com.example.cowbull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class Main3Activity extends AppCompatActivity {
    Button rt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rt1 = (Button) findViewById(R.id.retour1);
        rt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(i);
            }




        });
    }}
