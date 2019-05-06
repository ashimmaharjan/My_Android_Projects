package com.example.sqllite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqllite.Model.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText eWord,eMeaning;
    Button btnAddWord,btnViewWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eWord=findViewById(R.id.inputWord);
        eMeaning=findViewById(R.id.inputMeaning);
        btnAddWord=findViewById(R.id.addWord);
        btnViewWords=findViewById(R.id.viewWords);

        final MyHelper myHelper=new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id=myHelper.InsertData(eWord.getText().toString(),eMeaning.getText().toString(),sqLiteDatabase);
                if (id>0)
                {
                    Toast.makeText(MainActivity.this, "Values inserted successfully"+ String.valueOf(id), Toast.LENGTH_SHORT).show();
                    eWord.setText("");
                    eMeaning.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnViewWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showWords=new Intent(MainActivity.this,display_words.class);
                startActivity(showWords);
            }
        });
    }

}
