package com.example.runtimefragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Fragment01 fragment01;
    Fragment02 fragment02;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int showingFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button01);
        button.setOnClickListener(this);

        fragment01 = new Fragment01();
        fragment02 = new Fragment02();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, fragment01);
        fragmentTransaction.commit();

        showingFragment=1;

    }

    public void switchFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (showingFragment==1 ){
            fragmentTransaction.replace(R.id.frameLayout,fragment02);
            showingFragment = 2;
        }else{
            fragmentTransaction.replace(R.id.frameLayout,fragment01);
            showingFragment = 1;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switchFragment();
    }
}