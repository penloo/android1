package com.example.smash;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    SQLiteDatabase sqlDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setTitle("Smash");

        EditText text_school = (EditText) findViewById(R.id.text_school);
        EditText text_user = (EditText) findViewById(R.id.text_user);
        EditText text_password = (EditText) findViewById(R.id.text_password);
        Button btn_signup = (Button) findViewById(R.id.btn_signup);
        Button btn_signin = (Button) findViewById(R.id.btn_signin);
        DBHelper DB = new DBHelper(this);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String school = text_school.getText().toString();
                String user = text_user.getText().toString();
                String password = text_password.getText().toString();

                if (school.equals("") || user.equals("") || password.equals(""))
                    Toast.makeText(SignupActivity.this, "빈칸이 있습니다!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData(school, user, password);
                    if (insert == true) {
                        Toast.makeText(SignupActivity.this, "가입완료!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignupActivity.this, "가입실패!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}