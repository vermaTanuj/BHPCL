package com.example.bhpcl11_02_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class a1 extends AppCompatActivity {
    Spinner sp;
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        //Spinner :-
         sp=findViewById(R.id.sp);
         sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                 //
                 String item=adapterView.getItemAtPosition(position).toString();
                      if(item=="Select user"){
                          tv1=findViewById(R.id.tv1);
                          tv1.setText("Select Admin or Viewer");

                        Toast.makeText(a1.this, "Select Admin or Viewer", Toast.LENGTH_SHORT).show();
                      }
                 else if(item=="Admin"){
                     Intent i =new Intent(getApplicationContext(),a3.class);
                     startActivity(i);

                 }else{

                     Toast.makeText(a1.this, "you can only view Database", Toast.LENGTH_SHORT).show();
                   Intent i=new Intent(getApplicationContext(),a5.class);
                   startActivity(i);

                 }



             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

         //Arraylist for Spinner:-
        ArrayList<String>  list =new ArrayList<>();
        list.add("Select user");
        list.add("Admin");
        list.add("user");

        //Array adapter for spinner:-
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,list);

        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        sp.setAdapter(adapter);

    }
}