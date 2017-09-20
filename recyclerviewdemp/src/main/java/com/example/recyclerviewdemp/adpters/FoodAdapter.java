package com.example.recyclerviewdemp.adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewdemp.R;
import com.example.recyclerviewdemp.holder.FoodHolder;
import com.example.recyclerviewdemp.models.Food;

import java.util.ArrayList;

/**
 * Created by dell on 28-06-2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodHolder> {


    Context context;
    ArrayList<Food> foodItems;


    //context is an extra data jo activity ki value hold krta hai,declare context first then anything else


    public FoodAdapter(Context context, ArrayList<Food> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
    }


    @Override
    public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.simple_card_item,parent,false);

        //specifying the layout file which is to be used,chnage the file name when using eleswhere

        return new FoodHolder(v);

        //when object of layout file is to be made without activity then Inflator is used


    }

    @Override
    public void onBindViewHolder(FoodHolder holder, int position) {

        //DATA BINDING

        Food food = foodItems.get(position);
        //ctrl+alt+v
        //this is giving the position of food item

        holder.tvfname.setText(food.getFoodName());
        holder.tvftype.setText(food.getFoodType());
        holder.tvfprice.setText(String.valueOf(food.getFoodPrice()));

        //using String.valueOf becoz FoodPrice is double and settext requires only string so changing value to string
        //FoodName,FoodType,FoodPrice using this from the file Food.java


    }

    @Override
    public int getItemCount() {

        return foodItems.size();

    }
}
