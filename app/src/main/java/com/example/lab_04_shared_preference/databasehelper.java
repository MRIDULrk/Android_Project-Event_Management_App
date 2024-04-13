package com.example.lab_04_shared_preference;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Contact.db";
    public static final String TABLE_NAME="Contact_table";
    public static final String col1="ID";
    public static final String col2="Name";
    public static final String col3="Place";
    public static final String col4="Date_Time";
    public static final String col5="Capasity";
    public static final String col6="Email";
    public static final String col7="Phone";
    public static final String col8="Description";
    public databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PLACE TEXT,DATE_TIME TEXT,CAPASITY TEXT,EMAIL TEXT,PHONE TEXT,DESCRIPTION TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String place, String date_time,String capasity,String email,String phone,String description){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,place);
        contentValues.put(col4,date_time);
        contentValues.put(col5,capasity);
        contentValues.put(col6,email);
        contentValues.put(col7,phone);
        contentValues.put(col8,description);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " +TABLE_NAME,null);
        return res;

    }

}
