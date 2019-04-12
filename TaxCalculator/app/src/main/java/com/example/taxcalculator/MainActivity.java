package com.example.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText salary;
    TextView taxDisplay;
    Button btnTaxCalculate;
    Float taxCalculate, taxAmount;
    UserSalary userSalary=new UserSalary();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salary=findViewById(R.id.inputSalary);
        taxDisplay=findViewById(R.id.displayTax);
        btnTaxCalculate=findViewById(R.id.calculateTax);

        btnTaxCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userSalary.setUserSalary(salary.getText().toString());
                taxCalculate=Float.parseFloat(salary.getText().toString());
                taxCalculate=taxCalculate*12;
                if(taxCalculate<=200000)
                {
                    taxAmount=(taxCalculate)/100;
                    taxDisplay.setText("Your yearly tax amount is Rs." +taxAmount.toString());
                }
                else if(taxCalculate>200000 && taxCalculate<=350000)
                {
                    taxCalculate=taxCalculate-200000;
                    taxAmount=2000+((taxCalculate*15)/100);
                    taxDisplay.setText("Your yearly tax amount is Rs." +taxAmount.toString());
                }
                else if(taxCalculate>350000)
                {
                    taxCalculate=taxCalculate-350000;
                    taxAmount=24500+((taxCalculate*25)/100);
                    taxDisplay.setText("Your yearly tax amount is Rs." +taxAmount.toString());
                }

            }
        });

    }
}
