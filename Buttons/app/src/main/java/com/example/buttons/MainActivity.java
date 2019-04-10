package com.example.buttons;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActionBar actionBar;
    Button Button1,Button2,Button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Action Menu");
        actionBar.setSubtitle("19d");
        Button1=findViewById(R.id.btn1);
        Button1.setOnClickListener(this);

        Button2=findViewById(R.id.btn2);
        Button2.setOnClickListener(this);

        Button3=findViewById(R.id.btn3);
        Button3.setOnClickListener(this);


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ButtonOneClicked = new Intent(MainActivity.this,Button1Activity.class);
                ButtonOneClicked.putExtra("NAME","Assim fataha");
                ButtonOneClicked.putExtra("USERNAME","Assim1223");
                startActivity(ButtonOneClicked);
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ButtonTwoClicked=new Intent(MainActivity.this,ButtonSecondActivity.class);
                startActivity(ButtonTwoClicked);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn1:
                Toast.makeText(this, "First Button Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn2:
                Toast.makeText(this, "  Second Button Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn3:
                Toast.makeText(this, "Third Button Clicked", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.new_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_menu_audio:
                Toast.makeText(this, "Audio", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_menu_display:
                Toast.makeText(this, "Display", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_menu_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
