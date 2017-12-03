package com.example.khuza.classalert.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.khuza.classalert.R;
import com.example.khuza.classalert.controller.databaseConnect;

public class dataInsert extends AppCompatActivity {
    Button saveBtn;
    Spinner spDay,spTime;
    EditText courseName;
    databaseConnect db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);

        saveBtn = (Button) findViewById(R.id.dataSaver_btn);
        spDay = (Spinner) findViewById(R.id.Days_spn);
        spTime = (Spinner) findViewById(R.id.Time_spn);
        courseName = (EditText) findViewById(R.id.Course_Name_et);
        db=new databaseConnect(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //String.valueOf(spinner1.getSelectedItem())
                String Day = String.valueOf(spDay.getSelectedItem());
                String Time = String.valueOf(spTime.getSelectedItem());
                String CourseName = courseName.getText().toString();
                if(db.insert(Day,Time,CourseName)){
                    Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
