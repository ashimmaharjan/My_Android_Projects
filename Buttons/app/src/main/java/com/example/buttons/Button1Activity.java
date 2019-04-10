package com.example.buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Button1Activity extends AppCompatActivity {
    String name,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);

        name=getIntent().getStringExtra("NAME");
        username=getIntent().getStringExtra("USERNAME");

        Toast.makeText(this, "Name: "+name+"Username: "+username, Toast.LENGTH_SHORT).show();
    }
}
