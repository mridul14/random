package com.example.firebasedemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dell on 07-07-2017.
 */

public class QuoteHolder extends RecyclerView.ViewHolder {

    TextView tvQuote;
    TextView tvEmail;
    public QuoteHolder(View itemView) {
        super(itemView);

        tvQuote=(TextView) itemView.findViewById(R.id.tvQuote);
        tvEmail=(TextView) itemView.findViewById(R.id.tvEmail);
    }
}
