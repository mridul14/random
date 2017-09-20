package com.example.bacics_complicated;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AnswersActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvans1;
    private TextView tvans2;
    private TextView tvans3;
    private SharedPreferences mypref;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mypref = getSharedPreferences("MyPref", MODE_PRIVATE);
        tvans1 = (TextView) findViewById(R.id.tvans1);
        tvans2 = (TextView) findViewById(R.id.tvans2);
        tvans3 = (TextView) findViewById(R.id.tvans3);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);{

        }

        if(getIntent()!=null){
            Bundle extras=getIntent().getExtras();
            if(extras!=null){
                updateUI(extras);

            }
        }
    }

    private void updateUI(Bundle extras) {

        tvans1.setText(extras.getString(MainActivity.PACKAGE+".key_selection1"));
        tvans2.setText(extras.getString(MainActivity.PACKAGE+".key_selection2"));
        tvans3.setText(extras.getString(MainActivity.PACKAGE+".key_selection3"));
        savePref();
    }

    private void savePref() {
        SharedPreferences.Editor editor= mypref.edit();
        editor.putString("ans1",tvans1.getText().toString());
        editor.putString("ans2",tvans2.getText().toString());
        editor.putString("ans3",tvans3.getText().toString());
        editor.apply();
        Toast.makeText(this,"preferences saved",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(this,HomeActivity.class);
        startActivity(i);
    }
}
