package com.example.register;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rgGender;
    EditText fName,lName, inputDate;
    TextView disFN,disLN,disG,disDOB;
    Button btnReg;
    CheckBox chkBox;
    Calendar calendar;
    int day,month,year;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgGender=findViewById(R.id.rg_gender);
        fName=findViewById(R.id.fname);
        lName=findViewById(R.id.lname);
        btnReg=findViewById(R.id.reg);
        disFN=findViewById(R.id.displayFname);
        disLN=findViewById(R.id.displayLname);
        disG=findViewById(R.id.displayGender);
        inputDate =findViewById(R.id.date);
        disDOB=findViewById(R.id.displayDOB);
        disFN.setMovementMethod(new ScrollingMovementMethod());
        disLN.setMovementMethod(new ScrollingMovementMethod());
        disG.setMovementMethod(new ScrollingMovementMethod());
        disDOB.setMovementMethod(new ScrollingMovementMethod());
        chkBox=findViewById(R.id.chk);
        inputDate.setOnClickListener(this);
        btnReg.setEnabled(false);


        calendar=calendar.getInstance();

        day=calendar.get(calendar.DAY_OF_MONTH);
        month=calendar.get(calendar.MONTH);
        year=calendar.get(calendar.YEAR);
        setDate(year,month+1,day);

       rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rb_male)
                {
                    rgGender.setTag("Male");
                }
                else if (checkedId==R.id.rb_female)
                {
                    rgGender.setTag("Female");
                }
                else if (checkedId==R.id.rb_others)
                {
                    rgGender.setTag("Others");
                }
            }

        });


       chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked)
               {
                   Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                   btnReg.setEnabled(true);
               }
               else
               {
                   Toast.makeText(MainActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
                   btnReg.setEnabled(false);
               }
           }
       });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disFN.setText(fName.getText().toString());
                disLN.setText(lName.getText().toString());
                disG.setText(rgGender.getTag().toString());
                disDOB.setText(inputDate.getText().toString());

                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
            }
        });

        listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                setDate(year,month,dayOfMonth);
            }
        };

        datePickerDialog=new DatePickerDialog(this,listener,year,month+1,day);

    }
    public void setDate(int day, int month, int year)
    {
        inputDate.setText(day+"-"+month+"-"+year);
    }


    @Override
    public void onClick(View v) {
        datePickerDialog.show();
    }
}
