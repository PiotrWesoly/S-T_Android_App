package com.example.st;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class user_activity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    TextView mNameTv, mDescTv, mLongDescTv, mPriceTv;
    ImageView mImageTv, mIconTv;
    RatingBar mRatingTv;
    Button phone, sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


    mNameTv = findViewById(R.id.Name);
    mDescTv = findViewById(R.id.Desc);
    mLongDescTv = findViewById(R.id.LongDesc);
    mRatingTv = findViewById(R.id.ratingBar);
    mImageTv = findViewById(R.id.profilePic);
    mPriceTv = findViewById(R.id.Price);
    phone = (Button) findViewById(R.id.phoneBtn);
    sms = (Button) findViewById(R.id.messBtn);
   //int greenColor = Color.green(20);
   int whiteColor = Color.WHITE;

    phone = (Button)findViewById(R.id.phoneBtn);
    mRatingTv.setNumStars(5);
   // phone.setBackgroundColor(greenColor);
    phone.setTextColor(whiteColor);

        Intent intent = getIntent();

        mRatingTv.setNumStars(5);
        mRatingTv.setMax(5);

        String mName = intent.getStringExtra("iName");
        String mDesc = intent.getStringExtra("iDesc");
        String mLongDesc = intent.getStringExtra("iLongDesc");
        String mPrice = intent.getStringExtra("iPrice");
//        String mIconDesc1 = intent.getStringExtra("iIconDesc1");
        int mRating = intent.getIntExtra("iRating", 0);
        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);
//        byte[] mBytesIcon = getIntent().getByteArrayExtra("iIcon");
//        Bitmap bitmap1 = BitmapFactory.decodeByteArray(mBytesIcon, 0,mBytesIcon.length );




        mNameTv.setText(mName);
        mDescTv.setText(mDesc);
        mPriceTv.setText("Price: "+mPrice+"/€");
        mLongDescTv.setText(mLongDesc);
        mRatingTv.setRating(mRating);
        mImageTv.setImageBitmap(bitmap);
        mRatingTv.setNumStars(5);
//        mIconDescTv1.setText(mIconDesc1);
//        mIconTv.setImageBitmap(bitmap1);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Context context = getApplicationContext();
//                CharSequence text = "+48 273 823 234";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
                makePhoneCall();
            }
        });

        sms.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String smsNumber = "795585238";
                Uri uri = Uri.parse("smsto:" + smsNumber);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
            }});
    }

    private void makePhoneCall() {
        String number = "+48796585238";
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(user_activity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(user_activity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(user_activity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}