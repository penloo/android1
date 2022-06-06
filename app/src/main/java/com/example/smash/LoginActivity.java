package com.example.smash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText text_school, text_user, text_key;

    // DBHelper
    DBHelper DB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Smash");

        btn_login = (Button) findViewById(R.id.btn_login);

        text_school = (EditText) findViewById(R.id.text_school);
        text_user = (EditText) findViewById(R.id.text_user);
        text_key = (EditText) findViewById(R.id.text_key);

        DB = new DBHelper(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String school = text_school.getText().toString();
                String user = text_user.getText().toString();
                String key = text_key.getText().toString();

                if(school.equals("")||user.equals("")||key.equals(""))
                    Toast.makeText(LoginActivity.this, "Fill up all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(school, user, key);
                    if(checkuserpass){
                        Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}