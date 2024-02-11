package com.example.bhpcl11_02_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class a6 extends AppCompatActivity {


    EditText ed1,ed2,ed3;
    TextView tv1;
    Button but;

    ImageView iv1,iv2;

    DataBaseHelper helper;

    String  product,unit_cost, quontity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a6);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        tv1=findViewById(R.id.tv1);


        tv1=findViewById(R.id.tv1);

     ////////////////////////////////////////////////////
     //Filling the text view:-
       tv1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               unit_cost=ed2.getText().toString();
               quontity=ed3.getText().toString();
               int i=Integer.parseInt(quontity);
               int u=Integer.parseInt(unit_cost);
               int t=i*u;
               tv1.setText(String.valueOf(t));
           }
       });


        ///////////////////////////////////////////////

        ///////////////////////////////////////////////////
        //Initialise data base
        helper=new DataBaseHelper(this);
        ///////////////////////////////////////
/////////////////////////////////////////////////////
        //Immage view:-
        iv1=findViewById(R.id.iv1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            product=ed1.getText().toString();

            if(!product.isEmpty()){

                boolean b=helper.findInDataBase(product);
                if(b==true){
                    Intent i=new Intent(getApplicationContext(),a7.class);
                    i.putExtra("product_key",product);
                    startActivity(i);
                }
                else {
                    Toast.makeText(a6.this, "Enter valid product Name", Toast.LENGTH_SHORT).show();
                }

            }
            else{
                Toast.makeText(a6.this, "Fill the product name", Toast.LENGTH_SHORT).show();
            }


            }
        });


        iv2=findViewById(R.id.iv2);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product=ed1.getText().toString();

                if(!product.isEmpty()){

                    boolean b=helper.findInDataBase(product);
                    if(b==true){


                        boolean g=helper.deleteFromDataBase(product);
                        if(g==true){
                            Toast.makeText(a6.this, "Deleted from DataBase", Toast.LENGTH_LONG).show();
                            ed1.setText("");
                            ed2.setText("");
                            ed2.setText("");
                            Intent i=new Intent(getApplicationContext(),a5.class);
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(a6.this, " Not Deleted from DataBase", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else {
                        Toast.makeText(a6.this, "Enter valid product Name", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(a6.this, "Fill the product name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ///////////////////////////////////////////




/////////////////////////////////////////////////////////////////////////
        //Adding product in table:-
        but=findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String product_name=ed1.getText().toString();
                 unit_cost=ed2.getText().toString();
                 quontity=ed3.getText().toString();
                addData(product_name,unit_cost,quontity);
               Intent i=new Intent(getApplicationContext(),a5.class);
               startActivity(i);
               finish();
            }
        });

    }

    ///////////////////////////////////////////
         //Adding Sone thing into data base

    public void addData( String product_name, String unit_cost,String quontity){

    boolean b= helper.addProductHelper(product_name,unit_cost,quontity);
        if(b==true){
            Toast.makeText(this, "Data Entered into DataBase", Toast.LENGTH_SHORT).show();
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            tv1.setText("");
        }else{
            Toast.makeText(this, "Data not Entered", Toast.LENGTH_SHORT).show();
        }

    }


}