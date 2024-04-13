package com.example.lab_04_shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {

    EditText username,password;
    Button loginbtn;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);



        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginbtn=findViewById(R.id.loginbtn);

        String registeredUsername1= preferences.getString("name","");

        username.setText(registeredUsername1);



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameValue= username.getText().toString();
                String passwordValue= password.getText().toString();

                String registeredUsername= preferences.getString("name","");
                String registeredpassword= preferences.getString("password","");



                if(usernameValue.equals(registeredUsername)&& passwordValue.equals(registeredpassword))
                {

                    Intent intent = new Intent(Login_Activity.this,Event_Informaton.class);
                    startActivity(intent);


                }


            }
        });




    }
}