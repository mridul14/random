package com.example.intent_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.intent_demo.MainActivity.EXTRA_INFO;

public class SubActivity extends AppCompatActivity {

    private TextView tvFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        tvFact = (TextView) findViewById(R.id.tvFact);

        //receive


        if (getIntent() != null) {


            if (getIntent().hasExtra(EXTRA_INFO))//getintent ka object null ni hai ar jo value hmne putextra se pass ki hai wo hai ya ni
                {
                loadDataFromIntent();

            }
        }
    }
    private void loadDataFromIntent() {
        String fact=getIntent().getStringExtra(EXTRA_INFO);
        tvFact.setText(fact);
    }
}
