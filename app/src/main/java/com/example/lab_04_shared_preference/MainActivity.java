package com.example.lab_04_shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText name,email,phone,userid,password,repass;
    CheckBox checkbox1,checkbox2;
    Button login,exit,go;

    SharedPreferences preferences;

    String remember_user="";
    String remember_password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);

        String r_uname= preferences.getString("remember_user","");
        String r_pass = preferences.getString("remember_password","");

        if(r_uname.equals("yes")&& r_pass.equals("yes"))
        {

            Intent intent = new Intent(MainActivity.this,Event_Informaton.class);
            startActivity(intent);


        }

            setContentView(R.layout.activity_main);
            name = findViewById(R.id.name);
            email = findViewById(R.id.email);
            phone = findViewById(R.id.phone);
            userid = findViewById(R.id.userid);
            password = findViewById(R.id.password);
            repass = findViewById(R.id.repass);
            checkbox1 = (CheckBox)findViewById(R.id.checkbox1);
            checkbox2 = (CheckBox)findViewById(R.id.checkbox2);
            login = findViewById(R.id.login);
            exit = findViewById(R.id.exit);
            go = findViewById(R.id.go);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameValue= name.getText().toString();
                String emailValue= email.getText().toString();
                String phoneValue= phone.getText().toString();
                String useridValue= userid.getText().toString();
                String passwordValue= password.getText().toString();
                String repassValue= repass.getText().toString();


                if(checkbox1.isChecked()&&checkbox2.isChecked())
                {

                    remember_user="yes";
                    remember_password ="yes";


                }

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name",nameValue);
                editor.putString("email",emailValue);
                editor.putString("phone",phoneValue);
                editor.putString("userid",useridValue);
                editor.putString("password",passwordValue);
                editor.putString("repass",repassValue);
                editor.putString("remember_user",remember_user);
                editor.putString("remeber_password",remember_password);
                editor.apply();

                Intent intent = new Intent(MainActivity.this,Event_Informaton.class);
                startActivity(intent);




            }



        });



      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


              Intent intent = new Intent(MainActivity.this,Login_Activity.class);
              startActivity(intent);

          }
      });


      exit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


              moveTaskToBack(true);
              android.os.Process.killProcess(android.os.Process.myPid());
              System.exit(1);



          }
      });


    }
}