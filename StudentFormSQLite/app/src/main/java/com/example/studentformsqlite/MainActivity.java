package com.example.studentformsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAddStudents,btnViewStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddStudents=findViewById(R.id.addStudents);
        btnViewStudents=findViewById(R.id.viewStudents);

        btnViewStudents.setOnClickListener(this);
        btnAddStudents.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.addStudents:
            {
                Intent addStudents=new Intent(MainActivity.this,studentAddForm.class);
                startActivity(addStudents);
            }
            break;

            case R.id.viewStudents:
            {
                Intent viewStudents=new Intent(MainActivity.this,DisplayStudentInfo.class);
                startActivity(viewStudents);
            }
            break;
        }
    }
}
