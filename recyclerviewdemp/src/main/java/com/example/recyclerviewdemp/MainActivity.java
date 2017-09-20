package com.example.recyclerviewdemp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recyclerviewdemp.adpters.FoodAdapter;
import com.example.recyclerviewdemp.models.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Food> foodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvfood= (RecyclerView) findViewById(R.id.rvfood);
        fakeDataGenerator();
        rvfood.setLayoutManager(new LinearLayoutManager(this));
        rvfood.setAdapter(new FoodAdapter(this,foodItems));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fakeDataGenerator(){

        //data inside <> is called generic data type which is defined by us
        foodItems = new ArrayList<>();
        foodItems.add(new Food ("pasta",50,"Italian"));
        foodItems.add(new Food ("maggi",50,"Italian"));
        foodItems.add(new Food ("burger",50,"fast food"));
        foodItems.add(new Food ("chowmein",30,"fast food"));
        foodItems.add(new Food ("pepsi",40,"soft drink"));
        foodItems.add(new Food ("kurkure",20,"fast food"));
        foodItems.add(new Food ("chips",20,"fast food"));
        foodItems.add(new Food ("pizza",100,"Italian"));
        foodItems.add(new Food ("idly",55,"Indian"));
        foodItems.add(new Food ("dosa",45,"Indian"));
        foodItems.add(new Food ("momo",60,"indian"));
        foodItems.add(new Food ("pakodi",15,"Indian"));
        foodItems.add(new Food ("chai",10,"drink"));
        foodItems.add(new Food ("coffee",25,"drink"));
        foodItems.add(new Food ("kadhai chicken",200,"non-veg"));
        foodItems.add(new Food ("butter chicken",250,"non-veg"));
        foodItems.add(new Food ("kadhai paneer",150,"veg"));
        foodItems.add(new Food ("butter paneer",200,"veg"));
        foodItems.add(new Food ("palak paneer",230,"veg"));
        foodItems.add(new Food ("mix veg",100,"veg"));
        foodItems.add(new Food ("ice cream",50,"desert"));

    }
}
