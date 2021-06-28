package com.example.st;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<UserData> userDataArrayList;

    public MyAdapter(Context c, ArrayList<UserData> userDataArrayList) {
        this.c = c;
        this.userDataArrayList = userDataArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {

        holder.mName.setText(userDataArrayList.get(position).getName());
        holder.mImageView.setImageResource(userDataArrayList.get(position).getImage());
        holder.mRate.setRating(userDataArrayList.get(position).getRating());
        holder.mDesc.setText(userDataArrayList.get(position).getDesc());
        holder.mPrice.setText( userDataArrayList.get(position).getPrice()+"€/h");
        holder.mLocation.setText(userDataArrayList.get(position).getLocation());

//        holder.mIcon.setImageResource(tutorsDataArrayList.get(position).getIcon1());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClickListener(View v, int position) {

                String gName = userDataArrayList.get(position).getName();
                String gDesc = userDataArrayList.get(position).getDesc();
                String gLongDesc = userDataArrayList.get(position).getLongDesc();
                int gRating = userDataArrayList.get(position).getRating();
                String gPrice = userDataArrayList.get(position).getPrice();
                String gLocation = userDataArrayList.get(position).getLocation();
//                String gIconDesc1 = tutorsDataArrayList.get(position).getIconDesc1();

                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImageView.getDrawable();
//                BitmapDrawable bitmapDrawable1 = (BitmapDrawable)holder.mIcon.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();
//                Bitmap bitmap1 = bitmapDrawable1.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                ByteArrayOutputStream stream1 = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                bitmap1.compress(Bitmap.CompressFormat.PNG, 100, stream1);

                byte[] bytes = stream.toByteArray();
//                byte[] bytes1 = stream1.toByteArray();

                Intent intent = new Intent(c, user_activity.class);
                intent.putExtra("iName", gName);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iImage", bytes);
                intent.putExtra("iLongDesc", gLongDesc);
                intent.putExtra("iRating", gRating);
                intent.putExtra("iPrice", gPrice);
                intent.putExtra("iLocation", gLocation);
//                intent.putExtra("iIconDesc1", gIconDesc1);
//                intent.putExtra("iIcon", bytes1);
                c.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return userDataArrayList.size();
    }
}
