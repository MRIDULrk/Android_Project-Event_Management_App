package com.example.lab_04_shared_preference;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.database.Cursor;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listview extends AppCompatActivity {
    private ListView lvEvents;
    private databasehelper mydb;

    ArrayList<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        lvEvents = findViewById(R.id.lvEvents);
        mydb = new databasehelper(this);

        loadData();

        Cursor c = mydb.getAllData();

        lvEvents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                String event = listData.get(i);

                makeToast("Are You Want TO Delete:  "+"\n"+event);

                return false;
            }
        });



    }

    public void loadData()

    {

        Cursor cursor = mydb.getAllData();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();
            
        } else{

            while(cursor.moveToNext()) {

                listData.add(cursor.getString(0)+" \t" +cursor.getString(1)+"\n    "+cursor.getString(2)+"\n    "+cursor.getString(3));

            }

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.row_event,R.id.tvEventName,listData);
        lvEvents.setAdapter(adapter);


    }


    Toast t;
    private void makeToast(String s)
    {
       if(t != null)t.cancel();
       t = Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
       t.show();


    }



}









