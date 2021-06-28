package com.example.st;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class profile_screen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancestate){
        return inflater.inflate(R.layout.activity_user, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView mNameTv, mDescTv, mLongDescTv, mPriceTv;
        ImageView mImageTv, mIconTv;
        RatingBar mRatingTv;
        Button phone;

        mNameTv = (TextView) getActivity().findViewById(R.id.Name);
        mDescTv = (TextView) getActivity().findViewById(R.id.Desc);
        mLongDescTv = (TextView) getActivity().findViewById(R.id.LongDesc);
        mRatingTv = (RatingBar)getActivity().findViewById(R.id.ratingBar);
        mImageTv = (ImageView)getActivity().findViewById(R.id.profilePic);
        mPriceTv = (TextView) getActivity().findViewById(R.id.Price);
        phone = (Button) getActivity().findViewById(R.id.phoneBtn);
        //int greenColor = Color.green(20);
        int whiteColor = Color.WHITE;

        mNameTv.setText("John");
        mDescTv.setText("Math tutor");
        mLongDescTv.setText("Hello, I am a student of mathematics. I am on my first semester and I am looking for someone who can help me with some subjects. I am willing to have classes online as well as in person. I understand things pretty easily, but it is hard for me to follow professors.  ");
        mRatingTv.setRating(4.0f);
        mPriceTv.setText("");
        mImageTv.setImageResource(R.mipmap.daniel_student_foreground);
    }
}
