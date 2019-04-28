package com.example.filehandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    Button btnSave,btnLoad;
    private static final String FILE_NAME="myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput=findViewById(R.id.input);
        btnSave=findViewById(R.id.save);
        btnLoad=findViewById(R.id.load);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=userInput.getText().toString();
                try {
                    FileOutputStream fileOutputStream=openFileOutput(FILE_NAME,MODE_PRIVATE);
                    fileOutputStream.write(text.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(MainActivity.this, "Saved to: "+getFilesDir()+"/"+FILE_NAME, Toast.LENGTH_SHORT).show();
                    userInput.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                try {
                    FileInputStream fileInputStream=openFileInput(FILE_NAME);
                    InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    StringBuilder stringBuilder=new StringBuilder();
                    while ((data=bufferedReader.readLine()) !=null)
                    {
                        stringBuilder.append(data).append("\n");
                    }
                    userInput.setText(stringBuilder.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
