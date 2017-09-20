package com.example.intent_demo;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_INFO = "com.example.intent_demo.EXTRA_INFO";
    private View btn1;
    private View btn2;
    private View tvlabel1;
    private TextView tvlabel2;
    private ConstraintLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btn1 =(Button)findViewById(R.id.btn1);
       btn2 =(Button)findViewById(R.id.btn2);
        tvlabel1 =(TextView) findViewById(R.id.tvlabel1);
        tvlabel2 = (TextView) findViewById(R.id.tvlabel2);
        container = (ConstraintLayout) findViewById(R.id.container);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1:
                Intent nextIntent=new Intent(this,SubActivity.class);
                startActivity(nextIntent);
                break;
            case R.id.btn2:
                Intent dataIntent=new Intent(this,SubActivity.class);

                //pass data
                dataIntent.putExtra(EXTRA_INFO,"just a message ");

                        startActivity(dataIntent);
                break;
        }

    }
}
