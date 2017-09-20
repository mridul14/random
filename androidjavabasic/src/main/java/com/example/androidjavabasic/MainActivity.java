package com.example.androidjavabasic;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private TextView tvLabel;
    private Button btnFarzi;
    private ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLabel = (TextView) findViewById(R.id.tvlabel);
        btnFarzi = (Button) findViewById(R.id.btnfarzi);
        container = (ConstraintLayout) findViewById(R.id.container);

        btnFarzi.setOnClickListener(this);
        tvLabel.setOnLongClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "time is over", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
