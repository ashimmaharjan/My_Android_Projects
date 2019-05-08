package com.example.studentformsqlite;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentformsqlite.Model.Student;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    List<Student> studentList;
    Context context;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recycler_design,viewGroup,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {

        final Student student=studentList.get(i);
        studentViewHolder.tvName.setText(student.getStudent_name());
        studentViewHolder.tvEmail.setText(student.getEmail());
        studentViewHolder.tvPhoneNumber.setText(student.getPhoneNumber());

        Resources resources=context.getResources();
        int studentImage=((Resources) resources).getIdentifier(student.getImage(),"drawable",context.getPackageName());
        studentViewHolder.image.setImageResource(studentImage);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends ViewHolder{

        public TextView tvName;
        public TextView tvEmail;
        public TextView tvPhoneNumber;
        public ImageView image;
        public Button btnSelect,btnDelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.displayName);
            tvEmail=itemView.findViewById(R.id.displayEmail);
            tvPhoneNumber=itemView.findViewById(R.id.displayPhoneNumber);
            image=itemView.findViewById(R.id.displayImage);
            btnSelect=itemView.findViewById(R.id.selectStudent);
            btnDelete=itemView.findViewById(R.id.deleteStudent);
        }
    }
}
