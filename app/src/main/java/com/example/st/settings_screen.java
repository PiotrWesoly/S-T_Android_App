package com.example.st;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class settings_screen extends Fragment implements  View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancestate){
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        Button signOut = (Button) getActivity().findViewById(R.id.signOut);
        signOut.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), login.class);
        startActivity(intent);

    }
}
