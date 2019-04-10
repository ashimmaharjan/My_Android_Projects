package com.example.democalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fNum,sNum,res;
    Button btnAdd,btnSubs,btnMul,btnDiv;
    Double num1,num2,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fNum=findViewById(R.id.fnum);
        sNum=findViewById(R.id.snum);
        res=findViewById(R.id.res);
        btnAdd=findViewById(R.id.add);
        btnSubs=findViewById(R.id.subs);
        btnMul=findViewById(R.id.mul);
        btnDiv=findViewById(R.id.div);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(fNum.getText().toString());
                num2=Double.parseDouble(sNum.getText().toString());
                total=num1+num2;
                res.setText(total.toString());
                Toast.makeText(MainActivity.this, "The result is: " + total.toString(), Toast.LENGTH_LONG).show();

            }
        });
        btnSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(fNum.getText().toString());
                num2=Double.parseDouble(sNum.getText().toString());
                total=num1-num2;
                res.setText(total.toString());
                Toast.makeText(MainActivity.this, "The result is: " +total.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(fNum.getText().toString());
                num2=Double.parseDouble(sNum.getText().toString());
                total=num1*num2;
                res.setText(total.toString());
                Toast.makeText(MainActivity.this, "The result is: " +total.toString(), Toast.LENGTH_SHORT).show();


            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(fNum.getText().toString());
                num2=Double.parseDouble(sNum.getText().toString());
                total=num1/num2;
                res.setText(total.toString());
                Toast.makeText(MainActivity.this, "The result is: " +total.toString(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}
