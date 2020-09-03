package com.example.androidshaper.movietrackbypaging;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    CardView cardViewItem;
    ImageView imageViewMovie;
    TextView textViewMovie;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        cardViewItem=itemView.findViewById(R.id.movieItemCardView);
        imageViewMovie=itemView.findViewById(R.id.movieImageView);
        textViewMovie=itemView.findViewById(R.id.movieNameTextView);


    }
}
