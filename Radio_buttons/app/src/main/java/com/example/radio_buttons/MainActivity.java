package com.example.radio_buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgGender=findViewById(R.id.rg_gender);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rb_male)
                    Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_LONG).show();
                else if (checkedId==R.id.rb_female)
                    Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
