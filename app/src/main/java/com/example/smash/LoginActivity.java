package com.example.smash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Smash");

        Button btn_login = (Button) findViewById(R.id.btn_login);
        Button btn_signup = findViewById(R.id.btn_signup);
        EditText text_school = (EditText) findViewById(R.id.text_school);
        EditText text_user = (EditText) findViewById(R.id.text_user);
        EditText text_password = (EditText) findViewById(R.id.text_password);
        DBHelper DB = new DBHelper(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String school = text_school.getText().toString();
                String user = text_user.getText().toString();
                String password = text_password.getText().toString();

                if (school.equals("") || user.equals("") || password.equals(""))
                    Toast.makeText(LoginActivity.this, "Fill up all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(school, user, password);
                    if (checkuserpass) {
                        Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), RealMainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }



}