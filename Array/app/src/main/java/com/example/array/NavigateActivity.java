package com.example.array;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigateActivity extends AppCompatActivity {
    Button btnNav2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        btnNav2=findViewById(R.id.nav2);



        btnNav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finalActivity=new Intent(NavigateActivity.this,LastActivity.class);
                startActivity(finalActivity);
            }
        });
    }
}
