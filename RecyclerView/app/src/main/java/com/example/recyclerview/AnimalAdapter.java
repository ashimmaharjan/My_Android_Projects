package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter <AnimalAdapter.AnimalViewHolder>{
List<Animal> animalList;
Context context;

    public AnimalAdapter(List<Animal> animalList, Context context) {
        this.animalList = animalList;
        this.context=context;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sample_row,viewGroup,false);

        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int i) {

        final Animal animal=animalList.get(i);
        animalViewHolder.tvheading.setText(animal.getHeading());
        animalViewHolder.img.setImageResource(animal.getImg());
        animalViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          Toast.makeText(context,animal.getHeading(),Toast.LENGTH_SHORT).show();
        }
    });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder{
        public TextView tvheading;
        public ImageView img;
        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            tvheading=itemView.findViewById(R.id.sampleHeading);
            img=itemView.findViewById(R.id.sampleImage);

        }
    }
}
