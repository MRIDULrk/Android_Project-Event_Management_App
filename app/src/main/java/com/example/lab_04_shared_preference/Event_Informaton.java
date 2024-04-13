package com.example.lab_04_shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.NameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;

import org.chromium.base.task.AsyncTask;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Event_Informaton extends AppCompatActivity {

    databasehelper mydb;

    EditText name, place;
    CheckBox indoor, outdoor, online;
    EditText date_time, email, capacity, phone, description;
    TextView errormsg;
    Button upload, show, save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_informaton);

        mydb = new databasehelper(this);


        name = findViewById(R.id.name);
        place = findViewById(R.id.place);
        indoor = (CheckBox) findViewById(R.id.indoor);
        outdoor = (CheckBox) findViewById(R.id.outdoor);
        online = (CheckBox) findViewById(R.id.online);
        date_time = findViewById(R.id.date_time);
        email = findViewById(R.id.email);
        capacity = findViewById(R.id.capacity);
        phone = findViewById(R.id.phone);
        description = findViewById(R.id.description);
        errormsg = findViewById(R.id.errormsg);
        upload = findViewById(R.id.upload);
        show = findViewById(R.id.show);
        save = findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String ename = name.getText().toString();
                String eplcae = place.getText().toString();
                String edate_time = date_time.getText().toString();
                String emailvalue = email.getText().toString();
                String ecapacity = capacity.getText().toString();
                String ephone = phone.getText().toString();
                String edescription = description.getText().toString();
                //String emsg= errormsg.getText().toString();


                boolean insertData = mydb.insertData(ename, eplcae, edate_time, ecapacity, emailvalue, ephone, edescription);

                if (insertData = true)
                    Toast.makeText(Event_Informaton.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Event_Informaton.this, "Not Inserted", Toast.LENGTH_LONG).show();


            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Event_Informaton.this, listview.class);
                startActivity(intent);


            }
        });


    }

}