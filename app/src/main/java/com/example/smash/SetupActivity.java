package com.example.smash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SetupActivity extends AppCompatActivity {

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

                if(name.equals("") || interest.equals("") || time.equals("") || place.equals("") || department.equals("") || grade.equals(""))
                    Toast.makeText(SetupActivity.this, "빈칸이 존재합니다!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insertInfo = DB.insertInfo(name, department, grade, interest, time, place);
                    if(insertInfo){
                        Toast.makeText(SetupActivity.this, "설정 완료", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SetupActivity.this, "설정 실패", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}
