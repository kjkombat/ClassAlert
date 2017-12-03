package com.example.khuza.classalert.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.khuza.classalert.R;
import com.example.khuza.classalert.controller.databaseConnect;

public class Information extends AppCompatActivity {
    databaseConnect dbc;
    Button timeTableView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        timeTableView = (Button)findViewById(R.id.displayTimeTable);
        timeTableView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Information.this , dataEntry.class));
                }
            }
        );
    }
}
