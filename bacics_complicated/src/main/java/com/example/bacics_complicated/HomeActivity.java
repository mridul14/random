package com.example.bacics_complicated;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private MenuItem actionCLear;
    private SharedPreferences mypref;
    private TextView tvans2;
    private TextView tvans1;
    private TextView tvans3;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case (R.id.actionClear):
                mypref.edit().clear().apply();
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                finish();
                break;


        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mypref = getSharedPreferences("MyPref", MODE_PRIVATE);
        actionCLear = (MenuItem) findViewById(R.id.actionClear);
        tvans1 = (TextView) findViewById(R.id.tvans1);
        tvans2 = (TextView) findViewById(R.id.tvans2);
        tvans3 = (TextView) findViewById(R.id.tvans3);


        updateUI();


    }

    private void updateUI() {
        tvans1.setText(mypref.getString("ans1","not found"));
        tvans2.setText(mypref.getString("ans2","not found"));
        tvans3.setText(mypref.getString("ans3","not found"));


    }

}
