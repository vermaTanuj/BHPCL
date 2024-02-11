package com.example.bhpcl11_02_2024;

import android.content.Context;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;

    private ArrayList my_product,my_cost,my_quontity;

    public MyAdapter(Context context,ArrayList my_product, ArrayList my_cost,ArrayList my_quontity){

        this.context=context;
        this.my_product=my_product;
        this.my_cost=my_cost;
        this.my_quontity=my_quontity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);

        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textproductname.setText(String.valueOf(my_product.get(position)));
        holder.textunitcost.setText(String.valueOf(my_cost.get(position)));
        holder.textquontity.setText(String.valueOf(my_quontity.get(position)));

    }
    public int getItemCount() {
        return my_product.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textproductname,textunitcost,textquontity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textproductname=itemView.findViewById(R.id.textproductname);
            textunitcost=itemView.findViewById(R.id.textunitcost);
            textquontity=itemView.findViewById(R.id.textquontity);


        }
    }

}
