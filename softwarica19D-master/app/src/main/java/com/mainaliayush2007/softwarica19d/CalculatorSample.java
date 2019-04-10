package com.mainaliayush2007.softwarica19d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorSample extends AppCompatActivity {
EditText etFirstNum,etSecondNum,etResult;
Button btnAdd, btnSub, btnMultiply, btnDivide, btnModulo;
Double firstNum,secondNum,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_sample);
        etFirstNum = findViewById(R.id.et_first_num);
        etSecondNum = findViewById(R.id.et_second_num);
        etResult = findViewById(R.id.et_result);
        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnModulo = findViewById(R.id.btn_modulo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorSample.this,"Addition Selected",Toast.LENGTH_SHORT).show();
                firstNum = Double.parseDouble(etFirstNum.getText().toString());
                secondNum = Double.parseDouble(etSecondNum.getText().toString());
                result = firstNum + secondNum;
                etResult.setText(result.toString());


            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorSample.this,"Substraction Selected",Toast.LENGTH_SHORT).show();
                firstNum = Double.parseDouble(etFirstNum.getText().toString());
                secondNum = Double.parseDouble(etSecondNum.getText().toString());
                result = firstNum - secondNum;
                etResult.setText(result.toString());
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorSample.this,"Multiplication Selected",Toast.LENGTH_SHORT).show();
                firstNum = Double.parseDouble(etFirstNum.getText().toString());
                secondNum = Double.parseDouble(etSecondNum.getText().toString());
                result = firstNum * secondNum;
                etResult.setText(result.toString());
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorSample.this,"Division Selected",Toast.LENGTH_SHORT).show();
                firstNum = Double.parseDouble(etFirstNum.getText().toString());
                secondNum = Double.parseDouble(etSecondNum.getText().toString());
                result = firstNum / secondNum;
                etResult.setText(result.toString());
            }
        });

        btnModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorSample.this,"Modulo Selected",Toast.LENGTH_SHORT).show();
                firstNum = Double.parseDouble(etFirstNum.getText().toString());
                secondNum = Double.parseDouble(etSecondNum.getText().toString());
                result = firstNum % secondNum;
                etResult.setText(result.toString());
            }
        });


    }
}
