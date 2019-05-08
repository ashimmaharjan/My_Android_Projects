package com.example.studentformsqlite.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.studentformsqlite.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="Students_DB";
    private static final  int DB_VERSION=1;


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Student.TBL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query2="DROP TABLE IF EXISTS " +Student.TABLE_NAME;
        db.execSQL(query2);
        onCreate(db);
    }

    public long AddStudents(Student student)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("ID",student.getStudent_id());
        contentValues.put("STUDENT_NAME",student.getStudent_name());
        contentValues.put("CONTACT_NUMBER",student.getPhoneNumber());
        contentValues.put("EMAIL",student.getEmail());
        contentValues.put("IMAGE",student.getImage());

        long id=sqLiteDatabase.insert(Student.TABLE_NAME,null,contentValues);
        return id;
    }

    public List<Student> GetStudents(SQLiteDatabase sqLiteDatabase)
    {
        List<Student> students=new ArrayList<>();
        String fetchQuery="SELECT * FROM "+ Student.TABLE_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(fetchQuery,null);
        if (cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                students.add(new Student(cursor.getString(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            }
        }
        return students;
    }
}
