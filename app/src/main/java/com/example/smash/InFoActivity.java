package com.example.smash;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InFoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup);
        setTitle("Smash");

        Button settingBtn = (Button) findViewById(R.id.SettingBtn);
        EditText nameTxt = (EditText) findViewById(R.id.NameEdt);
        EditText interestTxt = (EditText) findViewById(R.id.InterestEdt);
        EditText timeTxt = (EditText) findViewById(R.id.TimeEdt);
        EditText placeTxt = (EditText) findViewById(R.id.PlaceEdt);
        Spinner departmentSpinner = (Spinner) findViewById(R.id.DepartmentSpinner);
        Spinner gradeSpinner = (Spinner) findViewById(R.id.GradeSpinner);
        DBHelper DB = new DBHelper(this);

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTxt.getText().toString();
                String interest = interestTxt.getText().toString();
                String time = timeTxt.getText().toString();
                String place = placeTxt.getText().toString();
                String department = (String) departmentSpinner.getSelectedItem();
                String grade = (String) gradeSpinner.getSelectedItem();
            }
        });

    }
}
