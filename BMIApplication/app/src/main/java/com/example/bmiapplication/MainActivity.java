package com.example.bmiapplication;

import android.renderscript.Float2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText weight,height;
    TextView displayResult;
    Button calculateBMI;
    Float userWeight,userHeight,BMI;
    UserValues userValues=new UserValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight=findViewById(R.id.inputweight);
        height=findViewById(R.id.inputheight);
        displayResult=findViewById(R.id.displayresult);
        calculateBMI=findViewById(R.id.calculate);

        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userValues.setWeightUser(weight.getText().toString());
                userValues.setHeightUser(height.getText().toString());
                userWeight=Float.parseFloat(weight.getText().toString());
                userHeight=Float.parseFloat(height.getText().toString());
                userHeight=userHeight/100;
                BMI=userWeight/(userHeight*userHeight);
                displayResult.setText(BMI.toString());

                if(BMI<18.5)
                {
                    Toast.makeText(MainActivity.this, "You are underweight.", Toast.LENGTH_SHORT).show();
                }
                else if(BMI>=18.5 && BMI<=24.9)
                {
                    Toast.makeText(MainActivity.this, "Congratulations!! you got normal weight.", Toast.LENGTH_SHORT).show();
                }
                else if(BMI==25 || BMI<=29.9)
                {
                    Toast.makeText(MainActivity.this, "You are overweight", Toast.LENGTH_SHORT).show();
                }
                else if(BMI>30)
                {
                    Toast.makeText(MainActivity.this, "Sorry but you got some serious obesity problem", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
