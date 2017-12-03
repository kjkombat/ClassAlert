package com.example.khuza.classalert.controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;

import com.example.khuza.classalert.Model.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khuza on 29-Nov-17.
 */

public class databaseConnect extends SQLiteOpenHelper  {
    Tag tag;

    public static final String dbName = "TimeTableAP.db";
    public static final String tableName = "Main";
    public static final String ID = "ID";
    public static final String subjectName = "SubName";
    public static final String day = "Day";
    public static final String time = "Time";


    public databaseConnect(Context context) {
        super(context, dbName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table "+tableName+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                subjectName+" TEXT NOT NULL,"+day + " TEXT NOT NULL,"+ time+" TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(sqLiteDatabase);
    }
    public boolean insert(String d, String t, String sub) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(day,d);
        cv.put(time,t);
        cv.put(subjectName,sub);
        long result= db.insert(tableName,null,cv);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }

    }
    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();


    }
    public void update() {
        SQLiteDatabase db = this.getWritableDatabase();

    }

    public Cursor getAllobjectByTime(String t){

        SQLiteDatabase db=this.getWritableDatabase();
        List<database> t_list=new ArrayList<>();
        //Cursor cursor= db.rawQuery("Select * from "+table_Name+" where "+time+"='"+t.trim()+"'",null);
        Cursor cursor= db.rawQuery("Select * from "+tableName,null);
        return cursor;
    }

}
