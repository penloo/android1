package com.example.smash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText schoolEdt;
    EditText userEdt;
    EditText passEdt;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Smash");

        Button login = (Button) findViewById(R.id.btn_login);
        EditText schoolEdt = (EditText) findViewById(R.id.school_text);
        EditText userEdt = (EditText) findViewById(R.id.user_text);
        EditText passEdt = (EditText) findViewById(R.id.key_text);

        dbHelper = new DBHelper(LoginActivity.this, 1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), SetupActivity.class);
                startActivity(intent);
            }
        });
    }
}