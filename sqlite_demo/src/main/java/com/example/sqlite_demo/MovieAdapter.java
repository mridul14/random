package com.example.sqlite_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sqlite_demo.holder.MovieHolder;
import com.example.sqlite_demo.models.Movie;

import java.util.ArrayList;

/**
 * Created by dell on 02-07-2017.
 */

public class MovieAdapter extends Adapter<MovieHolder> {

    Context context;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    ArrayList<Movie> movieList;



    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.movie_card_item,parent,false);

        return new MovieHolder(v);
    }



    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {

        Movie movie=movieList.get(position);

        holder.tvName.setText(movie.getMovie());
        holder.tvStudio.setText(movie.getStudio());
        holder.tvYear.setText(""+ movie.getYear());
        holder.tvRating.setText(""+movie.getRating());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
