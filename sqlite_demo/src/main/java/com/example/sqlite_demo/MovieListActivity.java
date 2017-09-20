package com.example.sqlite_demo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.sqlite_demo.contract.MovieContract;
import com.example.sqlite_demo.models.Movie;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

    private MovieContract contract;
    private ArrayList<Movie> movieList;
    private MovieAdapter adapter;
    private RecyclerView rvMovies;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        rvMovies = (RecyclerView) findViewById(R.id.rvMovies);
        contract = new MovieContract(this);
        c = contract.list();
        movieList = new ArrayList<>();
        cursorToArrayList(c);


        adapter = new MovieAdapter(this,movieList);
        LinearLayoutManager layout=new LinearLayoutManager(this);

        rvMovies.setLayoutManager(layout);
        rvMovies.setAdapter(adapter);

    }

    private void cursorToArrayList(Cursor c) {

        if (c!=null){
            if(c.getCount()>0){

            while (c.moveToNext()){
                long id=c.getLong(0);
                String name=c.getString(1);
                int year=c.getInt(2);
                double rating=c.getDouble(3);
                String studio=c.getString(4);
                movieList.add(new Movie(name,studio,year,id,rating));

            }

        }
        else {
            Toast.makeText(this, "add some data then come here", Toast.LENGTH_SHORT).show();
        }}
        else {
            Toast.makeText(this, "there was a problem", Toast.LENGTH_SHORT).show();
        }
    }

}
