package com.example.bacics_complicated;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rgq3;
    private RadioGroup rgq2;
    private RadioGroup rgq1;
    private RadioButton rbgeneric;
    private RadioButton rbbad;
    private RadioButton rbverybad;
    private RadioButton rbextremelybad;
    private RadioButton rbhome;
    private RadioButton rbroom;
    private RadioButton rbandroid;
    private RadioButton rbkuchnahi;
    private RadioButton rbekkaan;

public static final String PACKAGE="com.example.bacics_complicated";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rgq1 = (RadioGroup) findViewById(R.id.rgq1);
        rgq2 = (RadioGroup) findViewById(R.id.rgq2);
        rgq3 = (RadioGroup) findViewById(R.id.rgq3);
        rbgeneric = (RadioButton) findViewById(R.id.rbgeneric);
        rbbad = (RadioButton) findViewById(R.id.rbbad);
        rbverybad = (RadioButton) findViewById(R.id.rbverybad);
        rbextremelybad = (RadioButton) findViewById(R.id.rbextremelybad);
        rbhome = (RadioButton) findViewById(R.id.rbhome);
        rbroom = (RadioButton) findViewById(R.id.rbroom);
        rbandroid = (RadioButton) findViewById(R.id.rbandroid);
        rbkuchnahi = (RadioButton) findViewById(R.id.rbkuchnahi);
        rbekkaan = (RadioButton) findViewById(R.id.rbekkaan);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this); {

            }
        };

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

    @Override
    public void onClick(View v) {
        int idq1 = rgq1.getCheckedRadioButtonId();
        int idq2 = rgq2.getCheckedRadioButtonId();
        int idq3 = rgq3.getCheckedRadioButtonId();
        String selection1 = "";
        String selection3 = "";
        String selection2 = "";
        switch (idq1) {
            case R.id.rbgeneric:
                selection1 = rbgeneric.getText().toString();
                break;
            case R.id.rbbad:
                selection1 = rbbad.getText().toString();
                break;
            case R.id.rbverybad:
                selection1 = rbverybad.getText().toString();
                break;
            case R.id.rbextremelybad:
                selection1 = rbextremelybad.getText().toString();
                break;

        }
        switch (idq2){
            case R.id.rbhome:
                selection2=rbhome.getText().toString();
                break;
            case R.id.rbroom:
                selection2=rbroom.getText().toString();
                break;


        }
        switch (idq3){
            case R.id.rbandroid:
                selection3=rbandroid.getText().toString();
                break;
            case R.id.rbkuchnahi:
                selection3=rbkuchnahi.getText().toString();
                break;
            case R.id.rbekkaan:
                selection3=rbekkaan.getText().toString();

        }
        sendDataToNext(selection1,selection2,selection3);
    }

    private void sendDataToNext(String selection1, String selection2, String selection3) {
        Intent i=new Intent(this,AnswersActivity.class);
        i.putExtra(PACKAGE+".key_selection1",selection1);
        i.putExtra(PACKAGE+".key_selection2",selection2);
        i.putExtra(PACKAGE+".key_selection3",selection3);
        startActivity(i);
    }


}
