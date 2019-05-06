package com.example.sqllite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sqllite.Model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class display_words extends AppCompatActivity {

    private ListView lstWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_words);

        lstWords=findViewById(R.id.listWords);
        LoadWord();

    }

    public void LoadWord()
    {
        final MyHelper myHelper=new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();

        List <Word> wordList=new ArrayList<>();
        wordList=myHelper.getAllWords(sqLiteDatabase);

        HashMap<String ,String> hashMap=new HashMap<>();

        for (int i=0; i<wordList.size();i++)
        {
            hashMap.put(wordList.get(i).getWord(),wordList.get(i).getMeaning());
        }

        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet()));
        lstWords.setAdapter(stringArrayAdapter);
    }



}
