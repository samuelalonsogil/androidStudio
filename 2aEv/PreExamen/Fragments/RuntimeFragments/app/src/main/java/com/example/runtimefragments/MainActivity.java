package com.example.runtimefragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    FragmentDefault fragmentDefault;
    int showingFragment = 0;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button button01, button02;

    public void startFragments(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout01, fragmentDefault);
        fragmentTransaction.commit();
        showingFragment = 0;
    }

    public void initVariables(){
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentDefault = new FragmentDefault();

        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
    }

    public void startTransactions(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public void switchToFragment01(View view){
        startTransactions();

        if (showingFragment == 0 || showingFragment == 2) {
            fragmentTransaction.replace(R.id.frameLayout01, fragmentOne);
            showingFragment = 1;
            fragmentTransaction.commit();
        }

    }

    public void switchToFragment02(View view){
        startTransactions();

        if (showingFragment == 0 || showingFragment ==1) {
            fragmentTransaction.replace(R.id.frameLayout01, fragmentTwo);
            showingFragment = 2;
            fragmentTransaction.commit();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        startFragments();
    }

    @Override
    public void onClick(View view) {
        if (button01.getId() == view.getId() ) switchToFragment01(view);
        else if (button02.getId() == view.getId() ) switchToFragment02(view);
    }
}