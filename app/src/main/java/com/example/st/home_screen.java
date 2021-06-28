package com.example.st;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homescreen_nav()).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_settings:
                    selectedFragment = new settings_screen();
                break;
                case R.id.nav_messages:
//                    Intent intent = new Intent(Intent.ACTION_MAIN);
//                    intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
//                    startActivity(intent);
                    selectedFragment = new messages_screen();
                break;
                case R.id.nav_profile:
                    selectedFragment = new profile_screen();
                break;
                case R.id.nav_home:
                    selectedFragment = new homescreen_nav();
                break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}