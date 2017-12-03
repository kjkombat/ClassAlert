package com.example.khuza.classalert.view;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.khuza.classalert.R;
import com.example.khuza.classalert.controller.databaseConnect;

public class dataEntry extends AppCompatActivity {
    Button enterRow;
    databaseConnect db;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        tableLayout= findViewById(R.id.showTable);
        db = new databaseConnect(this);


        enterRow = (Button)findViewById(R.id.addRow);
        enterRow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(dataEntry.this , dataInsert.class));
            }
        }
        );
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);

        tableLayout.addView(tbrow0);

        TableRow tbrow1 = new TableRow(this);
        int i;
        int length =getResources().getStringArray(R.array.Times).length;
        String[] times=getResources().getStringArray(R.array.Times);
        StringBuffer stringBuffer=new StringBuffer();
            Cursor cursor = db.getAllobjectByTime("t");
            //Toast.makeText(getApplicationContext(),"records "+cursor.getCount(),Toast.LENGTH_SHORT).show();
            cursor.getCount();
           // stringBuffer.append(times[i]);
            while(cursor.moveToNext()){
                stringBuffer.append("\n"+cursor.getString(1)+" "+cursor.getString(3));
            }
            stringBuffer.append("\n\n");

        TextView tv7 = new TextView(this);
        tv7.setText(stringBuffer);
        tv7.setTextColor(Color.BLACK);
        tbrow0.addView(tv7);
        tableLayout.addView(tbrow1);


    }
}

