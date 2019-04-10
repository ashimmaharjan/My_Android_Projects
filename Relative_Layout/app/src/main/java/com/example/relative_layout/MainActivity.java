package com.example.relative_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgGender;
    EditText Name, Address;
    TextView disName, disAddress, disGender;
    Button btnRegister;
    CheckBox checkAccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgGender=findViewById(R.id.rg_gender);
        Name=findViewById(R.id.iname);
        Address=findViewById(R.id.iaddress);
        disName=findViewById(R.id.display_name);
        disAddress=findViewById(R.id.display_address);
        disGender=findViewById(R.id.display_gender);
        btnRegister=findViewById(R.id.register);
        checkAccept=findViewById(R.id.check_accept);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rg_male)
                {
                    rgGender.setTag("Male");
                }
                else if (checkedId==R.id.rg_female)
                {
                    rgGender.setTag("Female");
                }
            }
        });

        checkAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {
                    Toast.makeText(MainActivity.this, "You have accepted terms & conditions.", Toast.LENGTH_LONG).show();
                    btnRegister.setEnabled(true);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please accept our terms & conditions.", Toast.LENGTH_SHORT).show();
                    btnRegister.setEnabled(false);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disName.setText(Name.getText().toString());
                disAddress.setText(Address.getText().toString());
                disGender.setText(rgGender.getTag().toString());
                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
