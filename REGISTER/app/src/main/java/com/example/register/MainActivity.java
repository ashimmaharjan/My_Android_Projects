package com.example.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgGender;
    EditText fName,lName;
    TextView disFN,disLN,disG;
    Button btnReg;
    CheckBox chkBox;

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
        disFN.setMovementMethod(new ScrollingMovementMethod());
        disLN.setMovementMethod(new ScrollingMovementMethod());
        disG.setMovementMethod(new ScrollingMovementMethod());
        chkBox=findViewById(R.id.chk);

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

                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
            }
        });







    }
}
