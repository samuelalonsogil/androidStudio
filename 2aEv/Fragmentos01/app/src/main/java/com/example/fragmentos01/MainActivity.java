package com.example.fragmentos01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button01, button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
    }

    public void initVariables(){
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == button01.getId() ){
            replaceFragment(new Fragment01() );
        }
        else if(view.getId() == button02.getId()){
            replaceFragment(new Fragment02() );
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);

        fragmentTransaction.commit();
    }
}