package com.example.firebasedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by dell on 07-07-2017.
 */

public class QuoteAdapter extends RecyclerView.Adapter<QuoteHolder>{

    Context context;
    ArrayList<QuoteModel> list;

    public QuoteAdapter(Context context, ArrayList<QuoteModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public QuoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.simple_card,parent,false);


        return new QuoteHolder(v);
    }

    @Override
    public void onBindViewHolder(QuoteHolder holder, int position) {

        QuoteModel model=list.get(position);
        holder.tvQuote.setText(model.getQuote());
        holder.tvEmail.setText(model.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
