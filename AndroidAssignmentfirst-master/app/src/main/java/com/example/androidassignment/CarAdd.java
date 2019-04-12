package com.example.androidassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CarAdd extends AppCompatActivity {
    EditText make, year, color, purchase, engine;
    TextView resultmake, resultyear, resultcolor, resultpurchase, resultengine, display;
    Button createcar, creatediesel;
    GetterSetter getset = new GetterSetter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_add);
        make = findViewById(R.id.et_make);
        year = findViewById(R.id.et_year);
        color = findViewById(R.id.et_color);
        purchase = findViewById(R.id.et_purchase);
        engine = findViewById(R.id.et_engine);

//        resultmake = findViewById(R.id.tv_resultmake);
//        resultyear = findViewById(R.id.tv_resultyear);
//        resultcolor = findViewById(R.id.tv_resultcolor);
//        resultpurchase = findViewById(R.id.tv_resultpurchase);
//        resultengine = findViewById(R.id.tv_resultengine);

        createcar = findViewById(R.id.btn_createcar);
        creatediesel = findViewById(R.id.btn_creatediesel);
        display = findViewById(R.id.display);

        createcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String maketest=make.getText().toString();
//                resultmake.setText("The Vechile is Manufacture by " + make.getText().toString());
//                resultyear.setText("Made Year: " +  year.getText().toString());
//                resultcolor.setText("Car color: " +   color.getText().toString());
//                resultpurchase.setText( "Current value: "+  purchase.getText().toString());
//                resultengine.setText("Engine per liter: " + engine.getText().toString());
//
getset.setMake(make.getText().toString());
getset.setColor(color.getText().toString());
getset.setYear(year.getText().toString());
getset.setPurchase(purchase.getText().toString());
getset.setEngine(engine.getText().toString());
                String values = "\r\n" +
                        "\r\n" + display.getText() +
                        "\r\n" +" The Vechile is Manufacture by "+ getset.getMake() +
                        "\r\n" + " Made Year: "+ getset.getColor() +
                        "\r\n" + "Car color: " + getset.getYear() +
                        "\r\n" +  "Current value: "+ getset.getPurchase() +
                        "\r\n" + "Engine per liter: " + getset.getEngine() +
                        "\r\n";




                display.setText(values);
//                Log.d("values", "onClick: "+resultmake.getText());
            }
        });


    }
}
