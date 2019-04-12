package com.example.demoobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText et;
Button btn;
TextView tv;
GetterSetter g=new GetterSetter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.edittext);
        btn=findViewById(R.id.button);
        tv= findViewById(R.id.textone);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setEdittext(et.getText().toString());
                tv.setText(g.getEdittext());

            }
        });


    }
}
