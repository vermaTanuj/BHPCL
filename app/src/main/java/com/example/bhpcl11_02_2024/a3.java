package com.example.bhpcl11_02_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class a3 extends AppCompatActivity {

    EditText ed;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        ed=findViewById(R.id.ed);


        but=findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ed.getText().toString().trim();
                int i=21604;
                if (!s.isEmpty()) {
                    try {

                        int y=Integer.parseInt(s);
                        if(y==i){
                            Intent j=new Intent(getApplicationContext(), a4.class);
                            startActivity(j);
                            ed.setText("");
                        }
                        else{
                            Toast.makeText(a3.this, "Code is wrong", Toast.LENGTH_SHORT).show();
                        }


                    } catch (NumberFormatException e) {
                        Toast.makeText(a3.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(a3.this, "Please enter code", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}