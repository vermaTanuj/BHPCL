package com.example.bhpcl11_02_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class a7 extends AppCompatActivity {

    EditText ed2,ed3;
  TextView tv1;
    Button but_edit;
    String product_name,quontity,unit_cost;

  //  Data_Model  data_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a7);

        ed3=findViewById(R.id.ed3);
        ed2=findViewById(R.id.ed2);
       tv1 =findViewById(R.id.tv1);

        /////////////////////////////////////////////////////////
        //Recivind data from a6___



            product_name =  getIntent().getStringExtra("product_key");
            tv1.setText(product_name);






        ///////////////////////////////////////////////

        but_edit=findViewById(R.id.but_edit);
        but_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateProfile();
            }
        });
    }

    public void updateProfile(){
                product_name= tv1.getText().toString();
                unit_cost= ed2.getText().toString();
                quontity= ed3.getText().toString();



                DataBaseHelper helper=new DataBaseHelper(this);
        //Calling method from data base helper:-
        boolean b=helper.updateProfile(product_name,unit_cost,quontity);

        if(b==true){
            Toast.makeText(this, "Values updated YYYYYYYYYYY", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Values not updated", Toast.LENGTH_SHORT).show();
        }


    }

}