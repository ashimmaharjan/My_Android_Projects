package com.example.object_to_pass_values;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PassingObjectViaIntent extends AppCompatActivity {
    User_Details userDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_object_via_intent);

        userDetails=(User_Details)getIntent().getSerializableExtra("USER_DETAILS");
        Log.d("First name", userDetails.getFname());
    }
}
