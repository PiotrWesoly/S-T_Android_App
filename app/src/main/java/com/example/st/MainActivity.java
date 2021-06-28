package com.example.st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  logo = findViewById(R.id.logo);

        Thread bgthread = new Thread() {
            public void run() {
                try {
                    sleep(2*1000);
//                    Intent intent = new Intent(MainActivity.this, home_screen.class);
                    //Intent intent = new Intent(getBaseContext(),home_screen.class);
                    Intent intent = new Intent(getBaseContext(),login.class);

                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        };
//        logo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, home_screen.class);
//                startActivity(intent);
//            }
//        });
//    }
        bgthread.start();
    }
}