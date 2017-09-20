package com.example.service_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnService = (Button) findViewById(R.id.btnService);

        btnService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this,TestService.class);
        startService(i);

    }
}
