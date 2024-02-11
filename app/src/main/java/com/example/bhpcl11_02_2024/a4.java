package com.example.bhpcl11_02_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class a4 extends AppCompatActivity {

    ImageView iv2,iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4);

        //////////////////////////View data base
        iv1=findViewById(R.id.iv1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), a5.class);
                startActivity(i);
            }
        });
        /////////////////////////////////////////////////////////////


        ////////////////////////////////////////////////////////
        //AccessData Base//////////
        iv2=findViewById(R.id.iv2);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), a6.class);
                startActivity(i);
            }
        });
    }
}