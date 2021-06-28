package com.example.st;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class messages_screen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancestate){
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(intent);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button sms_butt = (Button) getActivity().findViewById(R.id.SMS_button);
        sms_butt.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                startActivity(intent);
            }});


    }
}
