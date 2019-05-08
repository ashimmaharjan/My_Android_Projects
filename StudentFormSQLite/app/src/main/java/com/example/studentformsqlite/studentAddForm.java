package com.example.studentformsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentformsqlite.Helper.DbHelper;
import com.example.studentformsqlite.Model.Student;

public class studentAddForm extends AppCompatActivity {

    EditText eID,eName,ePhone,eEmail,eImage;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add_form);

        eID=findViewById(R.id.inputID);
        eName=findViewById(R.id.inputName);
        ePhone=findViewById(R.id.inputPhone);
        eEmail=findViewById(R.id.inputEmail);
        eImage=findViewById(R.id.inputImgae);
        btnSubmit=findViewById(R.id.submit);

        final DbHelper dbHelper=new DbHelper(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(eID.getText().toString())) {
                    eID.setError("Please enter ID");
                    eID.requestFocus();
                } else if (TextUtils.isEmpty(eName.getText().toString())) {
                    eName.setError("Please enter name");
                    eName.requestFocus();
                } else if (TextUtils.isEmpty(ePhone.getText().toString())) {
                    ePhone.setError("Please enter contact number");
                    ePhone.requestFocus();
                } else if (TextUtils.isEmpty(eEmail.getText().toString())) {
                    eEmail.setError("Please enter email");
                    eEmail.requestFocus();
                } else if (TextUtils.isEmpty(eImage.getText().toString())) {
                    eImage.setError("Please enter image name");
                    eImage.requestFocus();
                } else {
                    long id = dbHelper.AddStudents(new Student(eID.getText().toString(),
                            eName.getText().toString(),
                            ePhone.getText().toString(),
                            eEmail.getText().toString(),
                            eImage.getText().toString()));
                    Toast.makeText(studentAddForm.this, "Student added successfully", Toast.LENGTH_SHORT).show();

                    eID.setText("");
                    eImage.setText("");
                    eName.setText("");
                    ePhone.setText("");
                    eEmail.setText("");
                }
            }
        });
    }
}
