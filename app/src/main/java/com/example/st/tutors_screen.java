package com.example.st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class tutors_screen extends AppCompatActivity {

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



        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(tutors_screen.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sort));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SortDropDown.setAdapter(myAdapter1);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(tutors_screen.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.filter));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterDropDown.setAdapter(myAdapter2);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(tutors_screen.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.city));
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
    private void prepareTutors(){

        ArrayList<UserData> userDataList = new ArrayList<>();


        UserData tutor = new UserData("Francisco","High School math, physics",R.mipmap.francisco_foreground, 4, 20);
        tutor.setLongDesc("My name is Francisco, I am a 23 year old student who studies applied mathematics. I’ve been always fascinated with applied mathematics and physics, and now I want to share my knowledge with students who struggle with their tests and exams.");
        tutor.setPrice("10.5");
        tutor.setType("Math");
        tutor.setLocation("Lisbon");
        userDataList.add(tutor);

        tutor = new UserData("Sofia","English C1",R.mipmap.sofia_foreground, 3, 19);
        tutor.setLongDesc("Hello, I’m Sofia. I offer English classes for people on every level of their education. I have CAE, IELTS, TOEFL certificates. I also spent 4 years studying English linguistic in London.");
        tutor.setPrice("9");
        tutor.setType("English");
        tutor.setLocation("Porto");
        userDataList.add(tutor);

        tutor = new UserData("Mark","Python, C++, java",R.mipmap.mark_foreground, 4, 20);
        tutor.setLongDesc("Welcome everyone! My name is Mark and I offer coding classes. I know over 10 programming languages and I can teach most of them, but I feel the most confident in Python, C++ and Java. ");
        tutor.setPrice("8.5");
        tutor.setType("Programming");
        tutor.setLocation("Lisbon");
        userDataList.add(tutor);

        tutor = new UserData("Randal","JavaScript, CSS",R.mipmap.randal_foreground, 5, 21);
        tutor.setLongDesc("Hello I'm Randal, I am 21 year old java developer, who is willing to help you with your programming difficulties. I worked in 3 comapnies, doing both front and backend. I am also doing project development for private companies.");
        tutor.setPrice("11");
        tutor.setType("Programming");
        tutor.setLocation("Porto");
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
