package com.example.sqlite_demo.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sqlite_demo.R;

/**
 * Created by dell on 01-07-2017.
 */

public class MovieHolder  extends RecyclerView.ViewHolder{

    public final CardView container;
    public final TextView tvName;
    public final TextView tvStudio;
    public final TextView tvYear;
    public final TextView tvRating;

    public MovieHolder(View itemView) {
        super(itemView);

        container = (CardView) itemView.findViewById(R.id.container);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvStudio = (TextView) itemView.findViewById(R.id.tvStudio);
        tvYear = (TextView) itemView.findViewById(R.id.tvYear);
        tvRating = (TextView) itemView.findViewById(R.id.tvRating);
    }
}
