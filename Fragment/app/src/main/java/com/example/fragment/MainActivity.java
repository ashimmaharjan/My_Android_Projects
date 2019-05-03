package com.example.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLoadFragment;
    boolean status =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoadFragment=findViewById(R.id.load_fragment);
        btnLoadFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(status)
        {
            BlankFragment frag1=new BlankFragment();
            fragmentTransaction.replace(R.id.fragment_container,frag1);
            fragmentTransaction.commit();
            btnLoadFragment.setText("Load Fragment 2");
            status=false;
        }
        else
        {
            BlankFragment2 frag2=new BlankFragment2();
            fragmentTransaction.replace(R.id.fragment_container,frag2);
            btnLoadFragment.setText("Load Fragment 1");
            fragmentTransaction.commit();
            status=true;

        }
    }
}
//fragment manager acts as a manager to run the transactions. and also dont forget to commmit as it is crucial as hell.