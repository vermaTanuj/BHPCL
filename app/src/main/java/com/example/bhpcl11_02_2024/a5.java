package com.example.bhpcl11_02_2024;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class a5 extends AppCompatActivity {
    RecyclerView recycleViev;
    ArrayList<String> product_name, unit_cost, quontity;
    DataBaseHelper helper;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5);

        helper=new DataBaseHelper(this);


        product_name=new ArrayList<>();
        unit_cost=new ArrayList<>();
        quontity=new ArrayList<>();


        recycleViev =findViewById(R.id.recycleview);

        adapter=new MyAdapter(this,product_name,unit_cost,quontity);
        recycleViev.setAdapter(adapter);
        recycleViev.setLayoutManager(new LinearLayoutManager(this));


        displayData();

    }

    //  //Receiving cursor for Recycle view;-

    private void displayData(){
        Cursor corsor=helper.getdata();

        if(corsor.getCount()==0){
            Toast.makeText(this, "No data exist", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(corsor.moveToNext()){

                product_name.add(corsor.getString(1));
                unit_cost.add(corsor.getString(2));
                quontity.add(corsor.getString(3));


            }
        }
    }
}