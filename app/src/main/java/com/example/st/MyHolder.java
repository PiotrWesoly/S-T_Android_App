package com.example.st;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

    ImageView mImageView;
    TextView mName, mDesc, mPrice, mLocation;
    RatingBar mRate;
    ItemClickListener itemClickListener;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.image);
        this.mName = itemView.findViewById(R.id.title);
        this.mRate = itemView.findViewById(R.id.ratingBar);
        this.mDesc = itemView.findViewById(R.id.desc);
        this.mPrice = itemView.findViewById(R.id.price);
        this.mLocation = itemView.findViewById(R.id.location);


        itemView.setOnClickListener(this);
    }

    public  void onClick(View v){
        this.itemClickListener.OnItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }

}
