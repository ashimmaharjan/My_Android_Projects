package com.example.studentformsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.studentformsqlite.Helper.DbHelper;
import com.example.studentformsqlite.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class DisplayStudentInfo extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Student> studentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student_info);

        final DbHelper dbHelper=new DbHelper(this);
        final SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList=dbHelper.GetStudents(sqLiteDatabase);
        StudentAdapter studentAdapter = new StudentAdapter(studentList,this);
        recyclerView.setAdapter(studentAdapter);

    }

}
