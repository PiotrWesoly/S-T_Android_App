package com.example.st;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;


public class students_screen extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    Spinner SortDropDown, filterDropDown, CityDropDown;

    SharedPreferences preferences;

    //ArrayList<tutorsData> tutorsDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);

        preferences = this.getSharedPreferences("My_Pref", MODE_PRIVATE);

        SortDropDown = (Spinner) findViewById(R.id.dropDownSort);
        filterDropDown = (Spinner) findViewById(R.id.filter);
        CityDropDown = (Spinner) findViewById(R.id. dropDownCity);
        mRecyclerView = findViewById(R.id.recyclerView);



        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(students_screen.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sort));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SortDropDown.setAdapter(myAdapter1);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(students_screen.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.filter));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterDropDown.setAdapter(myAdapter2);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(students_screen.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.city));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CityDropDown.setAdapter(myAdapter3);

        SortDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        prepareTutors();
                        break;
                    case 1:
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("Sort", "ascending");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 2:
                        editor = preferences.edit();
                        editor.putString("Sort", "descending");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 3:
                        editor = preferences.edit();
                        editor.putString("Sort", "ascending_rating");
//                        editor.putString("Filter", "Programming");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 4:
                        editor = preferences.edit();
                        editor.putString("Sort", "descending_rating");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 5:
                        editor = preferences.edit();
                        editor.putString("Sort", "ascending_cost");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 6:
                        editor = preferences.edit();
                        editor.putString("Sort", "descending_cost");
                        editor.apply();
                        prepareTutors();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        filterDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("Subject", "All");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 1:
                        editor = preferences.edit();
                        editor.putString("Subject", "Math");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 2:
                        editor = preferences.edit();
                        editor.putString("Subject", "Physics");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 3:
                        editor = preferences.edit();
                        editor.putString("Subject", "Programming");
//                        editor.putString("Filter", "Programming");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 4:
                        editor = preferences.edit();
                        editor.putString("Subject", "Biology");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 5:
                        editor = preferences.edit();
                        editor.putString("Subject", "English");
                        editor.apply();
                        prepareTutors();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        CityDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("City", "All");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 1:
                        editor = preferences.edit();
                        editor.putString("City", "Lisbon");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 2:
                        editor = preferences.edit();
                        editor.putString("City", "Porto");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 3:
                        editor = preferences.edit();
                        editor.putString("City", "Coimbra");
                        editor.apply();
                        prepareTutors();
                        break;
                    case 4:
                        editor = preferences.edit();
                        editor.putString("City", "Aveiro");
                        editor.apply();
                        prepareTutors();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


    private void prepareTutors() {

        ArrayList<UserData> userDataList = new ArrayList<>();

        UserData tutor = new UserData("Mark", "Looking for a math tutor", R.mipmap.mark_student_foreground, 5, 18);
        tutor.setLongDesc("Hi! My name is Mark and I am a high school student. I am looking for someone who can help me with math classes, especially calculus I and functions. I prefer classes online.");
        tutor.setPrice("10");
        tutor.setType("Math");
        tutor.setLocation("Aveiro");
        userDataList.add(tutor);

        tutor = new UserData("Daniel", "Looking for someone who teaches python", R.mipmap.daniel_student_foreground, 4, 22);
        tutor.setLongDesc("Hello everyone! I am a student of Computer Science, in This semester I have a subject called “Data Analysis in Python” and it is hard for me to understand a syntax and concept of python programming language. Any help will be appreciated.");
        tutor.setPrice("14");
        tutor.setType("Programming");
        tutor.setLocation("Lisbon");
        userDataList.add(tutor);

        tutor = new UserData("Isabela", "Looking for high school math tutor", R.mipmap.isabela_student_foreground, 4, 18);
        tutor.setLongDesc("Hi! My name is Isa (short for Isabela). I am a high school student and I struggle with mathematics, precisely derivatives and integrals. I am looking for a nice tutor, who is patient, since it is really hard for me to understand those concepts.");
        tutor.setPrice("12");
        tutor.setType("Math");
        tutor.setLocation("Porto");
        userDataList.add(tutor);

        tutor = new UserData("Mat", "Looking for biology help", R.mipmap.mat_student_foreground, 5, 25);
        tutor.setLongDesc("Hi, I am Mat! I am 25 year old student, on a first year of biology. I am looking for help regarding my studies, since I have hard time with biology. I need to find somebody, who can drive to my place or surroundings.");
        tutor.setPrice("20");
        tutor.setType("Biology");
        tutor.setLocation("Aveiro");
        userDataList.add(tutor);

        String mSortSetting = preferences.getString("Sort", "ascending");
        String mFilterSetting = preferences.getString("Subject", "None");
        String mCitySetting = preferences.getString("City", "None");

        if(mSortSetting.equals("ascending")){
            Collections.sort(userDataList, UserData.By_Name_Asc);
        }
        else if(mSortSetting.equals("descending")){
            Collections.sort(userDataList, UserData.By_Name_Desc);
        }
        else if(mSortSetting.equals("descending_rating")){
            Collections.sort(userDataList, UserData.By_Rating_Desc);
        }
        else if(mSortSetting.equals("ascending_rating")){
            Collections.sort(userDataList, UserData.By_Rating_Asc);
        }
        else if(mSortSetting.equals("descending_cost")){
            Collections.sort(userDataList, UserData.By_Price_Desc);
        }
        else if(mSortSetting.equals("ascending_cost")){
            Collections.sort(userDataList, UserData.By_Price_Asc);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        if(mFilterSetting.equals("Math")){
            for(int i=0; i<userDataList.size();i++) {
                if(userDataList.get(i).getType()!="Math"){
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }else if(mFilterSetting.equals("All")){
        }else if(mFilterSetting.equals("Programming")){
            for(int i=0; i<userDataList.size();i++) {
                if(!"Programming".equals(userDataList.get(i).getType())) {
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }else if(mFilterSetting.equals("Physics")){
            for(int i=0; i<userDataList.size();i++) {
                if(userDataList.get(i).getType()!="Physics"){
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }else if(mFilterSetting.equals("Biology")){
            for(int i=0; i<userDataList.size();i++) {
                if(userDataList.get(i).getType()!="Biology"){
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }else if(mFilterSetting.equals("English")){
            for(int i=0; i<userDataList.size();i++) {
                if(userDataList.get(i).getType()!="English"){
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }

        if(mCitySetting.equals("Lisbon")){
            for(int i=0; i<userDataList.size();i++) {
                if(userDataList.get(i).getLocation()!="Lisbon"){
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }else if(mCitySetting.equals("All")){
        }else if(mCitySetting.equals("Porto")){
            for(int i=0; i<userDataList.size();i++) {
                if(!"Porto".equals(userDataList.get(i).getLocation())) {
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }else if(mCitySetting.equals("Aveiro")){
            for(int i=0; i<userDataList.size();i++) {
                if(userDataList.get(i).getLocation()!="Aveiro"){
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }else if(mCitySetting.equals("Coimbra")){
            for(int i=0; i<userDataList.size();i++) {
                if(userDataList.get(i).getLocation()!="Coimbra"){
                    userDataList.remove(userDataList.get(i));
                    i--;
                }
            }
        }

        myAdapter = new MyAdapter(this, userDataList);
        mRecyclerView.setAdapter(myAdapter);

    }

}