package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView Recycler;
    List<Animal> animalList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareAnimalList();
        Recycler=findViewById(R.id.recyclerView);

        Recycler.setLayoutManager(new LinearLayoutManager(this));
        Recycler.setAdapter(new AnimalAdapter(animalList,getApplicationContext()));
    }
    public void prepareAnimalList()
    {
        animalList.add(new Animal("Dota 2",R.drawable.dota2));
        animalList.add(new Animal("Buddha",R.drawable.buddha));
        animalList.add(new Animal("Comic",R.drawable.comic));
        animalList.add(new Animal("Hello",R.drawable.hello));
        animalList.add(new Animal("Anime",R.drawable.anime));
        animalList.add(new Animal("Dota 2",R.drawable.dota2));
        animalList.add(new Animal("Buddha",R.drawable.buddha));
        animalList.add(new Animal("Comic",R.drawable.comic));
        animalList.add(new Animal("Hello",R.drawable.hello));
        animalList.add(new Animal("Anime",R.drawable.anime));
    }
}
