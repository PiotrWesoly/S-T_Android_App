package com.example.st;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class homescreen_nav extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancestate){
        View view = inflater.inflate(R.layout.activity_home_screen_nav, container, false);
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView tut_butt = (ImageView) getActivity().findViewById(R.id.tutor_logo);
        ImageView stu_butt = (ImageView) getActivity().findViewById(R.id.student_logo);
        stu_butt.setOnClickListener((View.OnClickListener) this);
        tut_butt.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.tutor_logo:
                intent = new Intent(getActivity(), tutors_screen.class);
                break;
            case R.id.student_logo:
                intent = new Intent(getActivity(), students_screen.class);
                break;
            default:
                break;
        }

        startActivity(intent);
    }
}
