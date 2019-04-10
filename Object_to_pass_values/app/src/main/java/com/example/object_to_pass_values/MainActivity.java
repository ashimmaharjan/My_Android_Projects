package com.example.object_to_pass_values;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnObj.findViewById(R.id.buttonOne);

    btnObj.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            User_Details user_details=new User_Details("Ashim", "Maharjan","Male");
            Intent passValueViaIntent=new Intent(MainActivity.this,PassingObjectViaIntent.class);
            passValueViaIntent.putExtra("USER_DETAILS",user_details);
            startActivity(passValueViaIntent);
        }
    });
    }

}
