package com.mainaliayush2007.softwarica19d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    /*Things Covered in this Activity and the corresponding layout file i.e. activity_main
    1. LinearLayout with vertical orientation
    2. Changing the background colors using xml file
    3. Changing the text colors using xml file
    4. How to handle click event of a button i.e using the onClickListener
    5. How to navigate from one activity to another using Intent

     */

    Button btnLinearLayout,btnLoginForm,btnCalculator,btnActivityLifecycle,btnSignupForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinearLayout = findViewById(R.id.btn_linear_layout);
        btnLoginForm = findViewById(R.id.btn_login_form);
        btnCalculator = findViewById(R.id.btn_calculator);
        btnActivityLifecycle = findViewById(R.id.btn_activity_life_cycle);
        btnSignupForm = findViewById(R.id.btn_signup_form);

        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linearLayoutIntent = new Intent(MainActivity.this,LinearLayoutSample.class);
                startActivity(linearLayoutIntent);
            }
        });

        btnLoginForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginFormIntent = new Intent(MainActivity.this,LoginFormSample.class);
                startActivity(loginFormIntent);
            }
        });

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculatorIntent =new Intent(MainActivity.this,CalculatorSample.class);
                startActivity(calculatorIntent);
            }
        });

        btnActivityLifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityLifeCycleIntent = new Intent(MainActivity.this,ActivityLifeCycleSample.class);
                startActivity(activityLifeCycleIntent);
            }
        });

        btnSignupForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent= new Intent(MainActivity.this,SignUpFormSample.class);
                startActivity(signupIntent);
            }
        });
    }
}
