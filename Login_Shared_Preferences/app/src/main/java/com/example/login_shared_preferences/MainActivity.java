package com.example.login_shared_preferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    EditText username,password;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String UName,Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.inputUsername);
        password=findViewById(R.id.inputPassword);
        btnLogin=findViewById(R.id.login);

        sharedPreferences=getSharedPreferences("APP", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty(password.getText().toString()))
                {
                    UName=username.getText().toString();
                    Pass=password.getText().toString();

                    if(UName.equals("admin") && Pass.equals("admin"))
                    {
                        editor.putString("USERNAME",UName);
                        Intent dashboard=new Intent(MainActivity.this,Dashboard.class);
                        dashboard.putExtra("USERNAME",UName);
                        startActivity(dashboard);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Enter username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
