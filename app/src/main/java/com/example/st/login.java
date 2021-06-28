package com.example.st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton loginBtn = (ImageButton) findViewById(R.id.login_button);
        Button singUp = (Button) findViewById(R.id.sign_up);



        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Register.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) startActivity(new Intent(login.this, home_screen.class));
            }

            private boolean validate() {
                boolean temp=true;
                TextView loginErr = (TextView) findViewById(R.id.loginStartErr);
                TextView passErr = (TextView) findViewById(R.id.passStartErr);
                TextInputEditText login = (TextInputEditText) findViewById(R.id.LoginFillStart) ;
                TextInputEditText password = (TextInputEditText) findViewById(R.id.PasswordFillStart) ;

                String loginVal =login.getText().toString();
                String passVal = password.getText().toString();
                if(loginVal.isEmpty()) {
                    loginErr.setText("Please enter information");
                    temp=false;
                }
                if(passVal.isEmpty()) {
                    passErr.setText("Please enter information");
                    temp=false;
                }
            return temp;
            }
        });
    }
}