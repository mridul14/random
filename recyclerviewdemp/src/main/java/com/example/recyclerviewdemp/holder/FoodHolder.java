package com.example.recyclerviewdemp.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.recyclerviewdemp.R;

/**
 * Created by dell on 28-06-2017.
 */

public class FoodHolder extends RecyclerView.ViewHolder {

   public TextView tvfname;
   public TextView tvftype;
  public  TextView tvfprice;;
  public  CardView container;


    public FoodHolder(View itemView) {
        super(itemView);


        tvfname= (TextView) itemView.findViewById(R.id.tvfname);
        tvftype= (TextView) itemView.findViewById(R.id.tvftype);
        tvfprice= (TextView) itemView.findViewById(R.id.tvfprice);
        container= (CardView) itemView.findViewById(R.id.container);
    }
}
