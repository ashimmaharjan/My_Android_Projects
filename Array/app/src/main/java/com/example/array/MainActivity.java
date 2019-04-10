package com.example.array;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText Username,Pwd;
    Button ButtonLogin,ButtonNavigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.etusername);
        Pwd = findViewById(R.id.etpassword);
        ButtonLogin = findViewById(R.id.btnLogin);
        ButtonNavigate=findViewById(R.id.btnNavigate);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Toast.makeText(MainActivity.this, "Username: " + Username.getText().toString() + "Password: " + Pwd.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            private boolean validate() {
                if (TextUtils.isEmpty(Username.getText().toString())) {
                    Username.setError("Enter Username");
                    Username.findFocus();
                    return false;
                } else if (TextUtils.isEmpty(Pwd.getText().toString())) {
                    Pwd.setError("Enter password");
                    Pwd.findFocus();
                    return false;
                }
                return true;
            }
        });

        ButtonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navigation=new Intent(MainActivity.this,NavigateActivity.class);
                startActivity(navigation);
            }
        });
    }



}
