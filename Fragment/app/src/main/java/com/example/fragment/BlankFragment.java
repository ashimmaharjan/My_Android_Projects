package com.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {

    EditText radius;
    Button btnCalArea;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        radius=view.findViewById(R.id.inputRadius);
        btnCalArea=view.findViewById(R.id.calculateAreaC);
        btnCalArea.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        if(!TextUtils.isEmpty(radius.getText().toString()))
        {
            Double rad=Double.parseDouble(radius.getText().toString());
            Double area=rad*rad*3.14;
            Toast.makeText(getActivity(), "The area of circle is: " +area, Toast.LENGTH_SHORT).show();
        }
    }
}
