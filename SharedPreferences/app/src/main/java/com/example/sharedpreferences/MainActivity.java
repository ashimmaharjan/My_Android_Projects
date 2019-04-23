package com.example.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    Button btnConfirm,btnGetValue,btnClear;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String FirstName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.inputName);

        btnConfirm=findViewById(R.id.confirm);
        btnConfirm.setOnClickListener(this);

        btnGetValue=findViewById(R.id.getValue);
        btnGetValue.setOnClickListener(this);

        btnClear=findViewById(R.id.clear);
        btnClear.setOnClickListener(this);

        sharedPreferences=getSharedPreferences("APP", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.confirm)
        {
            if (!TextUtils.isEmpty(name.getText().toString())) {

                    FirstName=name.getText().toString();
                    editor.putString("NAME",FirstName);
                    editor.commit();
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
            }
            else {

                Toast.makeText(this, "Cannot Save Empty Data", Toast.LENGTH_SHORT).show();
            }
        }

        else if(v.getId()==R.id.getValue)
        {
            Toast.makeText(this,sharedPreferences.getString("NAME","NULL"), Toast.LENGTH_SHORT).show();

        }
        else if(v.getId()==R.id.clear)
        {
                editor.remove("NAME").commit();
                name.setText("");
        }

    }
}
