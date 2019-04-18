package com.example.caraddanddisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText carName,manYear,colour,carPrice,carEngine;
    TextView displayCars;
    Button btnAdd;
    Car car=new Car();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carName=findViewById(R.id.inputCName);
        manYear=findViewById(R.id.inputYear);
        colour=findViewById(R.id.inputColour);
        carPrice=findViewById(R.id.inputPrice);
        carEngine=findViewById(R.id.inputEngine);
        displayCars=findViewById(R.id.output);
        btnAdd=findViewById(R.id.addCar);

        car.setName(carName.getText().toString());
        car.setYear(manYear.getText().toString());
        car.setColor(colour.getText().toString());
        car.setPrice(carPrice.getText().toString());
        car.setEngine(carEngine.getText().toString());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(carName.getText().toString()))
                {
                    carName.setError("Car name cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(manYear.getText().toString()))
                {
                    manYear.setError("Manufactured year cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(colour.getText().toString()))
                {
                    colour.setError("Colour of car cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(carPrice.getText().toString()))
                {
                    carPrice.setError("Price of car cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(carEngine.getText().toString()))
                {
                    carEngine.setError("Engine size of car cannot be empty");
                    return;
                }
                else {

                    displayCars.append("Car Name: " + carName.getText().toString() + "\n");
                    displayCars.append("Manufactured Year: " + manYear.getText().toString() + "\n");
                    displayCars.append("Colour: " + colour.getText().toString() + "\n");
                    displayCars.append("Purchased Price (Rs.): " + carPrice.getText().toString() + "\n");
                    displayCars.append("Engine Size (Ltrs.): " + carEngine.getText().toString() + "\n");
                }

            }
        });
    }
}
