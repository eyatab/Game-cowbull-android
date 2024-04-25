package com.example.cowbull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
       Button q,rt;
       TextView mono;
       TextView multi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        q = (Button) findViewById(R.id.exit);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        mono = (TextView) findViewById(R.id.monoj);
        multi = (TextView) findViewById(R.id.multij);
        mono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Main2Activity.this, monojoueur.class);
                startActivity(i);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Main2Activity.this, multijoueur.class);
                startActivity(i);
            }
        });

        rt = (Button) findViewById(R.id.retour2);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
            }




    });
}}
