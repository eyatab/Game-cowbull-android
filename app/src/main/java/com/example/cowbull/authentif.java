package com.example.cowbull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class authentif extends AppCompatActivity {
 TextView reg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentif);

        reg1=(TextView) findViewById(R.id.regi);
        reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(authentif.this, register2.class);
                startActivity(i);
            }




        });










    }
}
